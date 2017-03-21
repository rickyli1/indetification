package com.main.identification.controller;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.main.identification.model.AdminUser;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.repository.EquipmentRepository;
import com.main.identification.service.ConstantService;
import com.main.identification.service.EquipmentService;
import com.main.identification.service.PoiUploadService;
import com.main.identification.utils.IndentificationUtils;

/**
 * 
 * @author duqiao
 * @createtime 2017-03-12
 * 基础信息上传controller
 */
@Controller
public class BaseInfoUploadController{
	
	@Autowired
	public ConstantService constantsService;
	
	@Autowired
	public EquipmentService equipmentService;
	
	@Autowired
	public PoiUploadService poiUploadService;

	@RequestMapping(value = "/upload/init", method = RequestMethod.GET)
	public String uploadInit() {
		try{
			AdminUser adminUser = IndentificationUtils.getAdminUser();
			
			if(adminUser == null || StringUtils.isBlank(adminUser.getRoleId())) {
				return "redirect:/login";
			}else {
				//return "redirect:/login?error";
				return "/upload/upload";
			}
		}catch(Exception e) {
			return "redirect:/login";
		}
	}
	
    @RequestMapping(value = "/upload/baseInfoUpload")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
            List ls = poiUploadService.getExcelDate(targetFile.getAbsolutePath());
            if(ls != null){
            	HashMap<String, ConstantModel> parentMap = (HashMap<String, ConstantModel>) ls.get(0);
            	 for (Map.Entry<String, ConstantModel> entry : parentMap.entrySet()) {
            		 ConstantModel cm = entry.getValue();
            		 cm.setCreateBy("-1");
            		 cm.setLastModifyBy("-1");
            		 constantsService.addConstantModel(cm);
		         }
            	 HashMap<String, ConstantModel> childrenMap = (HashMap<String, ConstantModel>) ls.get(1);
            	 for (Map.Entry<String, ConstantModel> entry : childrenMap.entrySet()) {
            		 ConstantModel cm = entry.getValue();
            		 cm.setCreateBy("-1");
            		 cm.setLastModifyBy("-1");
            		 constantsService.addConstantModel(cm);
		         }
            	 HashMap<String, EquipmentModel> equipmentMap =  (HashMap<String, EquipmentModel>) ls.get(2);
            	 for (Map.Entry<String, EquipmentModel> entry : equipmentMap.entrySet()) {
            		 EquipmentModel em = entry.getValue();
            		 em.setCreateBy("-1");
            		 em.setLastModifyBy("-1");
            		 equipmentService.addEquipmentModel(em);
		         }
            }
        } catch (Exception e) {
        	model.addAttribute("message", "Upload failed!");
            e.printStackTrace();
            return  "/upload/upload";
        }
        model.addAttribute("message", "Upload sucess!");
        return "/upload/upload";
    }
    
    public int getParent(){
		int parent = constantsService.findParentSeq();
		return parent;
    }
    
    public int getchildren(){
    	int children = constantsService.findChildrenSeq();
    	return children;
    }

}