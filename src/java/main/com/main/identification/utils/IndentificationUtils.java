package com.main.identification.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.main.identification.model.AdminUser;

public class IndentificationUtils {
	public static String  DATE_FORMAT_YYMMDD = "yyyyMMdd HH:mm:ss";
	
	public static AdminUser getAdminUser() {
		return (AdminUser)SecurityContextHolder.getContext()  
			    .getAuthentication()  
			    .getPrincipal();  
	}
	
}