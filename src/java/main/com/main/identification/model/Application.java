package com.main.identification.model;

import java.io.Serializable;

public class Application extends BaseModel implements Serializable {

	private static final long serialVersionUID = 6040568253512679000L;
	private String applicationNo; // 申请编号
	private String applicationDate; // 申请日期YYYYMMDD
	private String companyNo; // 单位编号
	private String department; // 主要代表机构或装备部门
	private String appFilePath; // 申请文本文件路径
	private String resultFildPath; // 结论文本文件路径
	private String remark; // 备注
	
	public String getApplicationNo() {
		return applicationNo;
	}
	
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAppFilePath() {
		return appFilePath;
	}

	public void setAppFilePath(String appFilePath) {
		this.appFilePath = appFilePath;
	}

	public String getResultFildPath() {
		return resultFildPath;
	}

	public void setResultFildPath(String resultFildPath) {
		this.resultFildPath = resultFildPath;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
