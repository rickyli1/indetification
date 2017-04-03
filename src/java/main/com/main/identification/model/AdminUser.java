package com.main.identification.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AdminUser extends BaseModel implements UserDetails {
	private static final long serialVersionUID = 5249297571246463032L;
	private int userId;
	private String roleId;
	private String roleName;
	private String password;
	private Date loginDate;
	private String token;
	private String userName;
	private String updateDateFrom;
	private String updateDateTo;
	private String questionCategoryIds;
	private String questionCategoryNames;
	private String deleteUserIds;
	
	// DB
	private Date createDate;
	private Date updateDate;
	private String createor;
	private String updateor;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] rights = roleId.split(",");

		GrantedAuthority[] authorities = new GrantedAuthority[rights.length];

		for (int i = 0; i < rights.length; i++) {
			authorities[i] = new SimpleGrantedAuthority(rights[i]);
		}

		return Arrays.asList(authorities);
	}

	public String getUsername() {

		return userName;
	}

	public boolean isAccountNonExpired() {

		return true;
	}

	public boolean isAccountNonLocked() {

		return true;
	}

	public boolean isCredentialsNonExpired() {

		return true;
	}

	public boolean isEnabled() {

		return true;
	}


	public String getUpdateDateFrom() {
		return updateDateFrom;
	}

	public void setUpdateDateFrom(String updateDateFrom) {
		this.updateDateFrom = updateDateFrom;
	}

	public String getUpdateDateTo() {
		return updateDateTo;
	}

	public void setUpdateDateTo(String updateDateTo) {
		this.updateDateTo = updateDateTo;
	}

	public String getQuestionCategoryIds() {
		return questionCategoryIds;
	}

	public void setQuestionCategoryIds(String questionCategoryIds) {
		this.questionCategoryIds = questionCategoryIds;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDeleteUserIds() {
		return deleteUserIds;
	}

	public void setDeleteUserIds(String deleteUserIds) {
		this.deleteUserIds = deleteUserIds;
	}

	public String getQuestionCategoryNames() {
		return questionCategoryNames;
	}

	public void setQuestionCategoryNames(String questionCategoryNames) {
		this.questionCategoryNames = questionCategoryNames;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateor() {
		return createor;
	}

	public void setCreateor(String createor) {
		this.createor = createor;
	}

	public String getUpdateor() {
		return updateor;
	}

	public void setUpdateor(String updateor) {
		this.updateor = updateor;
	}
	
	
	
}
