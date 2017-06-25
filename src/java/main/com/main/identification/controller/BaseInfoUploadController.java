package com.main.identification.controller;

import java.io.File;
import java.util.ArrayList;
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
import com.main.identification.model.Application;
import com.main.identification.model.Company;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.model.Report;
import com.main.identification.service.ApplicationService;
import com.main.identification.service.CompanyUploadService;
import com.main.identification.service.ConstantService;
import com.main.identification.service.EquipmentService;
import com.main.identification.service.PoiUploadService;
import com.main.identification.service.ReportService;
import com.main.identification.utils.Constant;
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
	
	@Autowired
	public CompanyUploadService companyUploadService;
	

	@Autowired
	public ApplicationService applicationService;
	

	@Autowired
	public ReportService reportService;

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
//        deleteAllBaseInfoData();
        //保存
        try {
            file.transferTo(targetFile);
            List ls = poiUploadService.getExcelDate(targetFile.getAbsolutePath());
            
            poiUploadService.batchExportExcelDate(ls);
            
//            List<ConstantModel> constantList = new ArrayList<ConstantModel>();
//            List<Company> companyList = new ArrayList<Company>();
//            List<EquipmentModel> equipmentList = new ArrayList<EquipmentModel>();
//            List<Application> applicationList = new ArrayList<Application>();
//            List<Report> reportList = new ArrayList<Report>();
//            if(ls != null){
//            	HashMap<String, ConstantModel> parentMap = (HashMap<String, ConstantModel>) ls.get(0);
//            	 for (Map.Entry<String, ConstantModel> entry : parentMap.entrySet()) {
//            		 ConstantModel cm = entry.getValue();
//            		 cm.setCreateBy("-1");
//            		 cm.setLastModifyBy("-1");
////            		 constantsService.addConstantModel(cm);
//            		 constantList.add(cm);
//		         }
//            	
//            	 HashMap<String, ConstantModel> childrenMap = (HashMap<String, ConstantModel>) ls.get(1);
//            	 for (Map.Entry<String, ConstantModel> entry : childrenMap.entrySet()) {
//            		 ConstantModel cm = entry.getValue();
//            		 cm.setCreateBy("-1");
//            		 cm.setLastModifyBy("-1");
////            		 constantsService.addConstantModel(cm);
//            		 constantList.add(cm);
//		         }
//            	 
//            	 constantsService.batchAddConstantModel(constantList);
//            	 
//            	 HashMap<String, EquipmentModel> equipmentMap =  (HashMap<String, EquipmentModel>) ls.get(2);
//            	 for (Map.Entry<String, EquipmentModel> entry : equipmentMap.entrySet()) {
//            		 EquipmentModel em = entry.getValue();
//            		 em.setCreateBy("-1");
//            		 em.setLastModifyBy("-1");
//            		 equipmentList.add(em);
////            		 equipmentService.addEquipmentModel(em);
//		         }
//            	 equipmentService.batchAddEquipmentModel(equipmentList);
//            	 //获得companymap，调用接口插入相关数据
////            	 HashMap<String, String> companyMap =  (HashMap<String, String>) ls.get(3);
////            	 companyUploadService.addCompanyModel(companyMap);
//            	 
//            	 
//            	 HashMap<String, Company> companyMap =  (HashMap<String, Company>) ls.get(3);
//            	 for (Map.Entry<String, Company> entry : companyMap.entrySet()) {
//            		 Company company = entry.getValue();
//            		 company.setCreateBy("-1");
//            		 company.setLastModifyBy("-1");
//            		 company.setCompanyType("0");
//            		 company.setCompanyCode(company.getCompanyName());
//            		 companyList.add(company);
////            		 companyUploadService.insertCompany(em);
//		         }
//            	 companyUploadService.insertCompanyBatch(companyList);
//            	 
//            	 HashMap<String, Application> applicationMap =  (HashMap<String, Application>) ls.get(4);
//            	 for (Map.Entry<String, Application> entry : applicationMap.entrySet()) {
//            		 Application application = entry.getValue();
//            		 application.setCreateBy("-1");
//            		 application.setLastModifyBy("-1");
//            		 applicationService.insertApplication(application);
//		         }
//            	 
//            	 HashMap<String, Report> reportMap =  (HashMap<String, Report>) ls.get(5);
//            	 for (Map.Entry<String, Report> entry : reportMap.entrySet()) {
//            		 Report report = entry.getValue();
//            		 report.setCreateBy("-1");
//            		 report.setLastModifyBy("-1");
//            		 reportList.add(report);
//		         }
//            	 reportService.insertReportBatch(reportList);
//            }
        } catch (Exception e) {
        	model.addAttribute("msg", "文件导入失败!");
            e.printStackTrace();
            return "common/alert";
        }
        model.addAttribute("msg", "文件导入成功!");
        model.addAttribute("url", "upload/init"); 
		 
		return "common/alert";
    }
    
    /**
     * 
     */
    private void deleteAllBaseInfoData() {
    	Report report = new Report();
    	Application application = new Application();
    	ConstantModel constant  = new ConstantModel();
    	constant.setAttribute1(Constant.REPAIR_LEVEL);
    	constantsService.deleteConstantsByCondation(constant);
    	EquipmentModel equip = new EquipmentModel();
    	Company company = new Company();
    	equipmentService.deleteEquipByCondation(equip);
    	companyUploadService.deleteCompanyByCondation(company);
    	applicationService.deleteApplication(application);
    	reportService.deleteReport(report);
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