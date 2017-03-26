package com.main.identification.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.identification.model.ApplicationResult;
import com.main.identification.service.ApplicationService;

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
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
//		model.addAttribute("totalCount", 30);
//		model.addAttribute("adminUserList", adminUserBo.getAdminUser());
		return "/application/search";
	}

	@RequestMapping(value ="/searchList")
	public String getApplicationList(Model model, ApplicationResult application) {
		model.addAttribute("totalCount", applicationBo.selectApplicationResultCount(application));
		model.addAttribute("applicationResultList", applicationBo.searchList(application));
		
//		// yangqi test
//		ArrayList<ApplicationResult> resultList = new ArrayList<ApplicationResult>();
//		ApplicationResult apply = new ApplicationResult();
//		apply.setCompanyName("infosys");
//		apply.setApplicationNo("20170323001");
//		apply.setEquipmentName("ipad");
////		apply.setExpertName("杜乔");
//		resultList.add(apply);
//		
//		ApplicationResult apply1 = new ApplicationResult();
//		apply1.setCompanyName("infosys");
//		apply1.setApplicationNo("20170323002");
//		apply1.setEquipmentName("iphone");
////		apply1.setExpertName("常林");
//		resultList.add(apply1);
//		
//		model.addAttribute("applicationResultList", resultList);
		
		return "application/list";
	}
	
}
