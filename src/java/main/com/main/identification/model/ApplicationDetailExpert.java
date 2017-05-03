package com.main.identification.model;

import java.io.Serializable;

/**
 * 申请详情_专家Model
 * @author YangQi
 *
 */
public class ApplicationDetailExpert extends BaseModel implements Serializable {

	private static final long serialVersionUID = -1589936276646721293L;
	// 专家名
	private String expertName;
	// 专家编号
	private String expertNo;
	// 公司名
	private String companyName;
	// 公司编号
	private String companyNo;
	// 角色
	private String role;
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	public String getExpertNo() {
		return expertNo;
	}
	public void setExpertNo(String expertNo) {
		this.expertNo = expertNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
