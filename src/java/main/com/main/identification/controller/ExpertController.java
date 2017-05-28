package com.main.identification.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.Company;
import com.main.identification.model.Expert;
import com.main.identification.service.CompanyService;
import com.main.identification.service.ExpertService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;

@Controller
@RequestMapping("/expert")
public class ExpertController {
	
	@Autowired
	private ExpertService expertService;
	@Autowired
	private CompanyService companyService;

	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		
		Company company = new Company();
		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
        model.addAttribute("modifyCompanys", companyService.findCompanyList(company));
		
		return "/expert/search";
	}
	
	@RequestMapping(value ="/searchList")
	public String getApplicationList(Model model,@RequestBody Expert expert) {
		
		expert.setStartNo(PageUtil.getStartNo(expert.getPage(), Constant.PAGE_SIZE));
		expert.setPageSize(Constant.PAGE_SIZE);
		
		int totalCount = expertService.selectExpertCount(expert);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		model.addAttribute("pageSize", Constant.PAGE_SIZE);
		model.addAttribute("page", expert.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("expertResultList", expertService.selectExpertForApplication(expert));
		
		return "expert/list";
	}
	
	@ResponseBody
	@RequestMapping("/getExpertForApplication")
	public Map<String,Object> getExpertForApplicationRegister(@RequestBody Expert expert, Model model) {
		Map<String,Object> result = new HashMap<>();
		expert.setStartNo(PageUtil.getStartNo(expert.getPage(), Constant.PAGE_SIZE));
		expert.setPageSize(Constant.PAGE_SIZE);
		
		int totalCount = expertService.selectExpertCount(expert);
		result.put("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		result.put("pageSize", Constant.PAGE_SIZE);
		result.put("page", expert.getPage());
		result.put("totalCount", totalCount);
		result.put("applicationResultList", expertService.selectExpertForApplication(expert));
		
		return result;
	}
	
	@RequestMapping("/addInit")
	public String addInit(Model model) {
		Company company = new Company();
		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
		model.addAttribute("companys", companyService.findCompanyList(company));

		return "/expert/add";
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody Expert expert) {
		Expert expertModel = new Expert();
		expertModel.setExpertName(expert.getExpertName());
		expertModel.setCompanyNo(expert.getCompanyNo());
//		//取得专家List
		List<Expert> expertList = expertService.selectExpert(expertModel);
		if (expertList.size() > 0) {
			model.addAttribute("msg", "在同一单位，已经存在同名的专家!");
			model.addAttribute("url", "expert/init");
			return "common/alert";
		} 
//		equipmentModel = toModel(equipment);
		int result = expertService.addExpert(expert);

		if (result > 0) {
			model.addAttribute("msg", "插入成功!");
		} else {
			model.addAttribute("msg", "插入失败!");
		}

		model.addAttribute("url", "expert/init");

		return "common/alert";
	}
	
	@RequestMapping("/delete")
	public String init(Model model, @RequestBody String expertNo) {
		Expert expert = new Expert();
		expert.setExpertNo(expertNo);;
		expert.setLastModifyBy("-1");
		// 执行删除
		int result = -1;
		if(expertNo != null && !"".equals(expertNo)){
			result = expertService.deleteUpdateExpert(expert);
		}

		if (result > 0) {
			model.addAttribute("msg", "删除专家成功!");
		} else {
			model.addAttribute("msg", "删除专家失败!");
		}

		model.addAttribute("url", "expert/init");

		return "common/alert";
	}
	
	// 根据专家编号，取得专家信息，包括所在单位名称
	@ResponseBody
	@RequestMapping("/getDetail")
	public Expert getDetail(Model model,@RequestBody String expertNo) {
		Expert expert = new Expert();
		expert.setExpertNo(expertNo);
		expert.setStartNo(0);
		expert.setPageSize(1);
		List<Expert> resultList = expertService.selectExpertForApplication(expert);
		
//		Company company = new Company();
//		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
//		model.addAttribute("updateCompanys", companyService.findCompanyList(company));
		
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}else{
			return null;
		}
	}
	
	@RequestMapping("/modify")
	public String modify(Model model, @RequestBody Expert expert) {

		int result = expertService.modifyExpert(expert);
		
		if(result > 0) {
			model.addAttribute("msg", "更新成功!");
		}else {
			model.addAttribute("msg", "更新失败!"); 
		}
		 
		model.addAttribute("url", "expert/init"); 
		
		return "common/alert";
	}
}
