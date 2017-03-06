package com.main.identification.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.main.identification.model.AdminUser;
import com.main.identification.utils.IndentificationUtils;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "用户名或密码不正确!");
		}

		if (logout != null) {
			model.addObject("msg", "已经退出系统.");
		}
		model.setViewName("login");

		return model;

	}
	                      
	@RequestMapping(value = "/login/init", method = RequestMethod.GET)
	public String loginInit() {
		try{
			AdminUser adminUser = IndentificationUtils.getAdminUser();
			
			if(adminUser == null || StringUtils.isBlank(adminUser.getRoleId())) {
				return "redirect:/login";
			}else {
				//return "redirect:/login?error";
				return "redirect:/adminUser/init";
			}
		}catch(Exception e) {
			return "redirect:/login";
		}
	}
}
