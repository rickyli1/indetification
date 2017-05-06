package com.main.identification.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

		model.addAttribute("url", "equipment/init");

		return "common/alert";
	}

	private EquipmentModel toModel(EquipmentModel equipment) {
		EquipmentModel equipmentModel = new EquipmentModel();
		equipmentModel.setGroupNo(equipment.getGroupNo());
		equipmentModel.setSubGroupNo(equipment.getGroupNo());
		equipmentModel.setEquipmentNo(Constant.EQUIPMENT_FLAG+ String.valueOf(commonService.createSequenceId(Constant.EQUIPMENT_SEQ)));
		equipmentModel.setEquipmentName(equipment.getEquipmentName());
		equipmentModel.setRemark(equipment.getRemark());
		equipmentModel.setCreateBy("-1");
		equipmentModel.setLastModifyBy("-1");
		return equipmentModel;
	}

	
}
