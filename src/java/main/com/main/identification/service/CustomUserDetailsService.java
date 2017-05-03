package com.main.identification.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.main.identification.model.AdminUser;
import com.main.identification.repository.AdminUserRepository;

public class CustomUserDetailsService  implements UserDetailsService {
	@Autowired
	private AdminUserRepository adminUserRepository;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		AdminUser searchParam = new AdminUser();
		searchParam.setUserName(userName);
		
		AdminUser userLogin = adminUserRepository.loginCheck(searchParam);  
		
		 
		if(userLogin == null || StringUtils.isBlank(userLogin.getRoleId())) {
			throw new UsernameNotFoundException("没有该用户");  
		} else {
			return userLogin;
		}
       
	}
}
