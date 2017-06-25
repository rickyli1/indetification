package com.main.identification.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.Company;
import com.main.identification.service.CommonService;
import com.main.identification.service.CompanyService;
import com.main.identification.service.ConstantService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	public CompanyService companyService;
	
	@Autowired
	public CommonService commonService;
	
	@Autowired
	public ConstantService constantService;
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		
		//取得单位类型
		model.addAttribute("page",  "1");
		model.addAttribute("totalPage",  "1");
		return "/company/search";
	}

	@RequestMapping(value ="/searchList")
	public String getCompanyList(Model model,@RequestBody Company company) {
		
		company.setStartNo(PageUtil.getStartNo(company.getPage(), 30));
		company.setPageSize(30);
		int totalCount = companyService.selectCompanyResultCount(company);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, 30));
		model.addAttribute("pageSize", "30");
		model.addAttribute("page", company.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("companyResultList", companyService.selectCompanyResultList(company));
		
		return "company/list";
	}
	
	@RequestMapping("/addInit")
	public String addInit(Model model) {
		return "/company/add";
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody Company company) {
		Company companyModel = new Company();
		model.addAttribute("url", "company/init");
		if (company.getCompanyName() == "") {
			model.addAttribute("msg", "请输入单位名!");
			model.addAttribute("url", "company/addInit");
			return "common/alert";
		} 
		companyModel.setCompanyName(company.getCompanyName());
		
		int count = companyService.selectCompanyResultCountForAdd(companyModel);
		if (count > 0) {
			model.addAttribute("msg", "单位信息已经存在!");
			model.addAttribute("url", "company/addInit");
			return "common/alert";
		} 
		companyModel = company;
		companyModel.setCompanyNo(Constant.COMPANY_FLAG
				+ String.valueOf(commonService.createSequenceId(Constant.COMPANY_SEQ)));
		companyModel.setCompanyType("0");
		companyModel.setCreateBy("-1");
		companyModel.setLastModifyBy("-1");
		int result = companyService.addCompany(companyModel);

		if (result > 0) {
			model.addAttribute("msg", "新增单位成功!");
		} else {
			model.addAttribute("msg", "新增单位失败!");
			model.addAttribute("url", "company/addInit");
		}

		return "common/alert";
	}
	
	@RequestMapping("/delete")
	public String init(Model model, @RequestBody String companyNo) {
		Company companyModel = new Company();
		companyModel.setCompanyNo(companyNo);
		companyModel.setLastModifyBy("-1");
		// 执行删除
		int result = -1;
		if(companyNo != null && !"".equals(companyNo)){
			result = companyService.deleteCompany(companyModel);
		}

		if (result > 0) {
			model.addAttribute("msg", "删除单位成功!");
		} else {
			model.addAttribute("msg", "删除单位失败!");
		}

		model.addAttribute("url", "company/init");

		return "common/alert";
	}
	
	@ResponseBody
	@RequestMapping("/getDetail")
	public Company getDetail(Model model,@RequestBody String companyNo) {
		Company company = new Company();
		company.setCompanyNo(companyNo);
		List<Company> list = companyService.selectCompany(company);
		return list.get(0);
	}
	
	@RequestMapping("/update")
	public String update(Model model, @RequestBody Company company) {

		int result = companyService.updateCompany(company);
		if (result > 0) {
			model.addAttribute("msg", "变更单位成功!");
		} else {
			model.addAttribute("msg", "变更单位失败!");
		}

		model.addAttribute("url", "company/init");

		return "common/alert";
	}
	
}
