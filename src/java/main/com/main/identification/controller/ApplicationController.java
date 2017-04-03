package com.main.identification.controller;

import java.security.Principal;
import java.util.List;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.ApplicationRequstModel;
import com.main.identification.model.ApplicationResult;
import com.main.identification.model.Company;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.model.Expert;
import com.main.identification.service.ApplicationService;
import com.main.identification.service.CompanyService;
import com.main.identification.service.ConstantService;
import com.main.identification.service.EquipmentService;
import com.main.identification.service.ExpertService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;

/**
 * 申请信息管理controller
 * 
 * @author yangqi
 * @createtime 2017-03-19
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {
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
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		return "/application/search";
	}

	@RequestMapping(value ="/searchList")
	public String getApplicationList(Model model,@RequestBody ApplicationResult application) {
		
		application.setStartNo(PageUtil.getStartNo(application.getPage(), 10));
		application.setPageSize(10);
		// 设定专家姓名检索条件
		this.setExpertNameCon(application);
		int totalCount = applicationBo.selectApplicationResultCount(application);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, 10));
		model.addAttribute("pageSize", "10");
		model.addAttribute("page", application.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("applicationResultList", applicationBo.searchList(application));
		
		return "application/list";
	}
	
	/**
	 * 设定专家姓名检索条件
	 * @param applyCondition
	 * @return 设定后的检索条件
	 */
	private ApplicationResult setExpertNameCon(ApplicationResult applyCondition){
		if(applyCondition.getExpertNameCon().isEmpty()){
			return applyCondition;
		}
		
		String expertNameConSql = "";
		
		Expert expertCon = new Expert();
		expertCon.setExpertName("%"+applyCondition.getExpertNameCon()+"%");
		// 根据专家姓名取得专家List
		List<Expert> expertList = expertBo.selectExpert(expertCon);
		
		for(Expert expert:expertList){
			expertNameConSql = expertNameConSql.concat(" or report.LEADER_NO = '"+expert.getExpertNo()+"'");
			expertNameConSql = expertNameConSql.concat(" or report.EXPERTS_NO like '%;"+expert.getExpertNo()+";%'");
		}
		
		if(!expertNameConSql.isEmpty()){
			// 去掉第一个[ or ]
			applyCondition.setExpertNameCon(expertNameConSql.substring(4, expertNameConSql.length()));
		} else {
			applyCondition.setExpertNameCon(" 1=2 ");
		}
		return applyCondition;
	}
	
	@RequestMapping("/addInit")
	public String addInit(Model model) {
		Company company = new Company();
		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
        model.addAttribute("companys", companyService.findCompanyList(company));
		
		return "/application/add";
	}
	
	@ResponseBody
	@RequestMapping("/getApplicationData")
	public ApplicationRequstModel getApplicationData(Model model) {
		ApplicationRequstModel  result = new ApplicationRequstModel();
		
		//取得专家List
		Expert expertCon = new Expert();
		List<Expert> expertList = expertBo.selectExpert(expertCon);
		
		//取得设备List
		List<EquipmentModel> equipmentList = equipmentService.findEquipmentList();
		
		//取得修理级别
		ConstantModel constant = new ConstantModel();
		constant.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
		
		result.setEquipments(equipmentList);
		result.setExperts(expertList);
		result.setRepairLevels(repairLevelList);
		
		return result;
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody ApplicationAddModel applicationAddModel) {
		int result = applicationBo.addApplicationInfo(applicationAddModel);
		
		 if(result > 0) {
			 model.addAttribute("msg", "插入成功!");
		 }else {
			 model.addAttribute("msg", "插入失败!"); 
		 }
		 
		 model.addAttribute("url", "application/init"); 
		 
		return "common/alert";
	}

}
