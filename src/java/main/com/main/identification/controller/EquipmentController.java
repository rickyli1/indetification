package com.main.identification.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.Company;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.model.EquipmentResult;
import com.main.identification.model.EqupmentRequstModel;
import com.main.identification.service.ApplicationService;
import com.main.identification.service.CommonService;
import com.main.identification.service.CompanyService;
import com.main.identification.service.ConstantService;
import com.main.identification.service.EquipmentService;
import com.main.identification.service.ExpertService;
import com.main.identification.service.PoiExportService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;
import com.main.identification.utils.TimeUtils;

/**
 * 申请信息管理controller
 * 
 * @author duqiao
 * @createtime 2017-04-11
 */
@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	
	private static Logger logger = Logger.getLogger(BaseInfoUploadController.class); 
	
	@Autowired
	public ApplicationService applicationBo;
	
	@Autowired
	public ExpertService expertBo;
	
	@Autowired
	public EquipmentService equipmentService;
	
	@Autowired
	public ConstantService constantService;
	
	@Autowired
	public CompanyService companyService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
	    ConstantModel constantModel = new ConstantModel();
        constantModel.setConstantType(Constant.PARENT_TYPE);
        model.addAttribute("constants", constantService.findConstantList(constantModel));
        
        ConstantModel constantModel2 = new ConstantModel();
        constantModel2.setConstantType(Constant.CHILDREN_TYPE);
        model.addAttribute("constantsChild", constantService.findConstantList(constantModel2));
			
    	ConstantModel constant = new ConstantModel();
		constant.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
		model.addAttribute("repairLevelList",repairLevelList);
		
		return "/equipment/search";
	}
	
	@RequestMapping("/initEquipment")
	public String initEquipment(Model model, Principal principal) {
	    ConstantModel constantModel = new ConstantModel();
        constantModel.setConstantType(Constant.PARENT_TYPE);
        model.addAttribute("constants", constantService.findConstantList(constantModel));
        
        ConstantModel constantModel2 = new ConstantModel();
        constantModel2.setConstantType(Constant.CHILDREN_TYPE);
        model.addAttribute("constantsChild", constantService.findConstantList(constantModel2));
			
    	ConstantModel constant = new ConstantModel();
		constant.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
		model.addAttribute("repairLevelList",repairLevelList);
		model.addAttribute("page",  "1");
		model.addAttribute("totalPage",  "1");
		return "/equipment/searchEquipment";
	}
	

	@RequestMapping(value ="/searchEquipmentList")
	public String getApplicationList(Model model,@RequestBody EquipmentResult equipment) {
		
		equipment.setStartNo(PageUtil.getStartNo(equipment.getPage(), Constant.PAGE_SIZE));
		equipment.setPageSize(Constant.PAGE_SIZE);
		if(!StringUtils.isEmpty(equipment.getEquipmentName())){
			equipment.setEquipmentName("%"+equipment.getEquipmentName()+"%");
		}
		// 设定专家姓名检索条件
//		this.setExpertNameCon(equipment);
		int totalCount = equipmentService.selectEquipmentResultCount(equipment);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		model.addAttribute("pageSize", Constant.PAGE_SIZE);
		model.addAttribute("page", equipment.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("equipmentResultList", equipmentService.searchEquipmentList(equipment));
		
		return "equipment/list";
	}
	
	/**
	 * 用于单表查询
	 * @param model
	 * @param equipment
	 * @return
	 */
	@RequestMapping(value ="/findEquipmentList")
	public String findApplicationList(Model model,@RequestBody EquipmentResult equipment) {
		
		equipment.setStartNo(PageUtil.getStartNo(equipment.getPage(), Constant.PAGE_SIZE));
		equipment.setPageSize(Constant.PAGE_SIZE);
		if(!StringUtils.isEmpty(equipment.getEquipmentName())){
			equipment.setEquipmentName("%"+equipment.getEquipmentName()+"%");
		}
		// 设定专家姓名检索条件
//		this.setExpertNameCon(equipment);
		int totalCount = equipmentService.selectEquipmentCount(equipment);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		model.addAttribute("pageSize", Constant.PAGE_SIZE);
		model.addAttribute("page", equipment.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("equipmentResultList", equipmentService.findEquipmentList2(equipment));
		
		return "equipment/listEquipment";
	}
	
	/**
	 * 描述：通过 jquery.form.js 插件提供的ajax方式导出Excel
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value ="/exportEquipmentList")
	public  String  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.info("通过 jquery.form.js 提供的ajax方式导出文件！");
		OutputStream os = null;  
		Workbook wb = null;    //工作薄
		
		try {
			//模拟数据库取值
			List<EquipmentResult> list = equipmentService.exportEquipmentList(null);
			
			//导出Excel文件数据
			PoiExportService util = new PoiExportService();
			File file =util.getExcelDemoFile("/export/承修单位选择范围g.xls");
			
			String sheetName="总名录";  
			wb = util.writeNewExcel(file, sheetName,list); 
			
			String fileName= Constant.FILE_NAME + "_" +TimeUtils.getStringFromTime(new Date(), TimeUtils.FORMAT_DATE_NO) +".xls";
		    response.setContentType("application/vnd.ms-excel");
		    response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
		    os = response.getOutputStream();
			wb.write(os);  
		    
//		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("ajaxUploadExcel failed:" + e.getMessage());
		}
		finally{
			os.flush();
			os.close();
			wb.close();
		} 
		return null;
	}
	
//	
	@RequestMapping("/addInit")
	public String addInit(Model model) {
//		Company company = new Company();
//		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
//        model.addAttribute("companys", companyService.findCompanyList(company));
        
        ConstantModel constantModel = new ConstantModel();
        constantModel.setConstantType(Constant.PARENT_TYPE);
        model.addAttribute("constants", constantService.findConstantList(constantModel));
        
//        ConstantModel constantModel2 = new ConstantModel();
//        constantModel2.setConstantType(Constant.CHILDREN_TYPE);
//        model.addAttribute("constantsChild", constantService.findConstantList(constantModel2));
		
		return "/equipment/add";
	}
	
	@ResponseBody
	@RequestMapping("/updateInit")
	public EquipmentResult updateInit(Model model,@RequestBody EquipmentResult select) {
		
		EquipmentResult equipment =  equipmentService.selectEquipmentInfoByNo(select.getEquipmentNo());
		
		ConstantModel constantModel = new ConstantModel();
        constantModel.setConstantType(Constant.PARENT_TYPE);
        List<ConstantModel> list1 = constantService.findConstantList(constantModel);
        List<ConstantModel> listConstants = new ArrayList<>();
        for(ConstantModel constantModel1 : list1){
//        	if(constantModel1.getConstantNo().equals(equipment.getGroupNo())){
        		listConstants.add(constantModel1);
//        	}
        }
        model.addAttribute("constants", listConstants);
//        model.addAttribute("equipment", equipment);
        equipment.setfList(listConstants);
        ConstantModel constantModel2 = new ConstantModel();
        constantModel2.setConstantType(Constant.CHILDREN_TYPE);
        constantModel2.setParentNo(equipment.getGroupNo());
        List<ConstantModel> list2 = constantService.findConstantList(constantModel2);
        listConstants = new ArrayList<>();
        for(ConstantModel constantModel1 : list2){
//        	if(constantModel1.getConstantNo().equals(equipment.getSubGroupNo())){
        		listConstants.add(constantModel1);
//        	}
        }
        model.addAttribute("constantsChild", listConstants);
        equipment.setcList(listConstants);

		return equipment;
	}	
	
	@ResponseBody
	@RequestMapping("/getApplicationData")
	public EqupmentRequstModel getApplicationData(Model model, @RequestBody EquipmentModel equipment) {
		EqupmentRequstModel  result = new EqupmentRequstModel();
//		//取得修理级别
//		ConstantModel constant = new ConstantModel();
//		constant.setConstantType(Constant.REPAIR_LEVEL);
//		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
//		
//	    ConstantModel constantModel = new ConstantModel();
//        constantModel.setConstantType(Constant.PARENT_TYPE);
//        List<ConstantModel> parentConstants = constantService.findConstantList(constantModel);
        
        ConstantModel constantModel2 = new ConstantModel();
        constantModel2.setConstantType(Constant.CHILDREN_TYPE);
        if(!StringUtils.isEmpty(equipment.getGroupNo())){
        	constantModel2.setParentNo(equipment.getGroupNo());
        	List<ConstantModel> childrenConstants = constantService.findConstantList(constantModel2);
            model.addAttribute("constantsChild", childrenConstants);
    		result.setChildrenConstants(childrenConstants);
        }
        
//		result.setParentConstants(parentConstants);
//		result.setRepairLevels(repairLevelList);
		
		return result;
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody EquipmentModel equipment) {
		EquipmentModel equipmentModel = new EquipmentModel();
		equipmentModel.setEquipmentName(equipment.getEquipmentName());		
		//取得设备List
		List<EquipmentModel> equipmentList = equipmentService.findEquipmentList(equipmentModel);
		if (equipmentList.size() > 0) {
			model.addAttribute("msg", "设备名称已存在!");
			model.addAttribute("url", "equipment/init");
			return "common/alert";
		} 
		equipmentModel = toModel(equipment);
		int result = equipmentService.addEquipmentModel(equipmentModel);

		if (result > 0) {
			model.addAttribute("msg", "插入成功!");
		} else {
			model.addAttribute("msg", "插入失败!");
		}

		model.addAttribute("url", "equipment/initEquipment");

		return "common/alert";
	}

	private EquipmentModel toModel(EquipmentModel equipment) {
		EquipmentModel equipmentModel = new EquipmentModel();
		equipmentModel.setGroupNo(equipment.getGroupNo());
		equipmentModel.setSubGroupNo(equipment.getSubGroupNo());
		equipmentModel.setEquipmentNo(Constant.EQUIPMENT_FLAG+ String.valueOf(commonService.createSequenceId(Constant.EQUIPMENT_SEQ)));
		equipmentModel.setEquipmentName(equipment.getEquipmentName());
		equipmentModel.setRemark(equipment.getRemark());
		equipmentModel.setCreateBy("-1");
		equipmentModel.setLastModifyBy("-1");
		return equipmentModel;
	}

	
	
	@RequestMapping("/deleteEquipment")
	public String deleteEquipment(Model model, @RequestBody String equipmentNo) {
		EquipmentModel equipmentModel = new EquipmentModel();
		// 执行删除
		int result = -1;
		if(equipmentNo != null && !"".equals(equipmentNo)){
			//软删除数据
			equipmentModel.setDeleteFlag(Constant.DELETE_FLAG_TRUE);
			equipmentModel.setLastModifyBy("-1");
			equipmentModel.setEquipmentNo(equipmentNo);
			result = equipmentService.updateEquipment(equipmentModel);
		}
		if (result > 0) {
			model.addAttribute("msg", "删除设备成功!");
		} else {
			model.addAttribute("msg", "删除设备失败!");
		}

		model.addAttribute("url", "equipment/initEquipment");

		return "common/alert";
	}
	
	@RequestMapping("/updateEquipment")
	public String updateEquipment(Model model, @RequestBody EquipmentModel equipmentModel) {
		int result = -1;
		if(equipmentModel != null && !"".equals(equipmentModel.getEquipmentNo())){
			equipmentModel.setLastModifyBy("-1");
			result = equipmentService.updateEquipment(equipmentModel);
		}
		if (result > 0) {
			model.addAttribute("msg", "更新设备成功!");
		} else {
			model.addAttribute("msg", "更新设备失败!");
		}
		model.addAttribute("url", "equipment/initEquipment");

		return "common/alert";
	}
}
