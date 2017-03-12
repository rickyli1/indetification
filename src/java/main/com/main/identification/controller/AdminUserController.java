package com.main.identification.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.identification.model.AdminUser;
import com.main.identification.service.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
	@Autowired
	public AdminUserService adminUserBo;
	
	
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		model.addAttribute("totalCount", 30);
		model.addAttribute("adminUserList", adminUserBo.getAdminUser());
		return "/adminUser/search";
	}
	
	@RequestMapping("/list")
	public String getAdminUserList(Model model, AdminUser adminUser) {
		model.addAttribute("adminUserList", adminUserBo.getAdminUser(adminUser));
		return "adminUser/list";
	}
	
//	
//	@RequestMapping("/add")
//	public String addAdminUserList(Model model, AdminUser adminUser) {
//		adminUser.setCreateId("admin");
//		adminUser.setRoleId("ADMIN");
//		adminUser.setCreateor("system");
//		adminUser.setUpdateId("admin");
//		adminUser.setUpdateor("system");
//		 int result = adminUserBo.addAdminUser(adminUser);
//		 
//		 if(result > 0) {
//			 model.addAttribute("result", "插入成功!");
//		 }else {
//			 model.addAttribute("result", "插入失败!"); 
//		 }
//		return "adminUser/adminUser";
//	}
	
	
	
}
