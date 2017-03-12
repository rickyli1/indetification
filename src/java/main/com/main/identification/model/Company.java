package com.main.identification.model;

import java.io.Serializable;

public class Company extends BaseModel implements Serializable{

	private static final long serialVersionUID = -3513357204981202994L;
	private String companyNo; // 单位编号
	private String companyName; // 单位名称
	private String companyType; // 单位类型
	private String companyCode; // 单位代号
	private String remark; // 备注
	
	public String getCompanyNo() {
		return companyNo;
	}
	
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
