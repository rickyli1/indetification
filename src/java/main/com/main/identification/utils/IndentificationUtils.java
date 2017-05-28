package com.main.identification.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.main.identification.model.AdminUser;
import com.main.identification.model.BaseModel;

public class IndentificationUtils {
	public static String  DATE_FORMAT_YYMMDD = "yyyyMMdd HH:mm:ss";
	
	public static AdminUser getAdminUser() {
		return (AdminUser)SecurityContextHolder.getContext()  
			    .getAuthentication()  
			    .getPrincipal();  
	}
	
	public static void setUserInfo(BaseModel model) {
		AdminUser adminUser = getAdminUser();
		model.setCreateBy(adminUser.getUserName());
		model.setCreateId(adminUser.getUserId());
		model.setUpdateId(adminUser.getUserId());
		model.setLastModifyBy(adminUser.getUserName());
	}
	
	
	public static String formatDate(String dataStr) {
 
		if(StringUtils.isNotEmpty(dataStr) && StringUtils.length(dataStr)== 8) {
			return StringUtils.substring(dataStr, 0, 4) + "-" + StringUtils.substring(dataStr, 4, 6) + "-" + StringUtils.substring(dataStr, 6, 8);
		}
		 
		return "";
	}
	
}