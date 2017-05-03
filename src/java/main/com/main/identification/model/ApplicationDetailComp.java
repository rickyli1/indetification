package com.main.identification.model;

import java.io.Serializable;

/**
 * 申请详情Model
 * @author YangQi
 *
 */
public class ApplicationDetailComp extends BaseModel implements Serializable {

	private static final long serialVersionUID = 2605152911749990123L;
	// 申请代号
	private String applicationNo;
	// 单位编号
	private String companyNo;
	// 单位名称
	private String companyName;
	// 单位代号
	private String companyCode;
	// 申请日期
	private String applicationDate;
	// 主要代表机构
	private String department;
	// 组长编号
	private String leaderNo;
	// 专家编号
	private String expertsNo;
	// 检索组员专家参数
	private String expertsCon;
	// 申请文件名称
	private String appFileName;
	// 申请文件编号
	private String appFileNo;
	// 结论文件名称
	private String resultFileName;
	// 结论文件名称
	private String resultFileNo;
	
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
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
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLeaderNo() {
		return leaderNo;
	}
	public void setLeaderNo(String leaderNo) {
		this.leaderNo = leaderNo;
	}
	public String getExpertsNo() {
		return expertsNo;
	}
	public void setExpertsNo(String expertsNo) {
		this.expertsNo = expertsNo;
	}
	public String getExpertsCon() {
		return expertsCon;
	}
	public void setExpertsCon(String expertsCon) {
		this.expertsCon = expertsCon;
	}
	public String getAppFileName() {
		return appFileName;
	}
	public void setAppFileName(String appFileName) {
		this.appFileName = appFileName;
	}
	public String getAppFileNo() {
		return appFileNo;
	}
	public void setAppFileNo(String appFileNo) {
		this.appFileNo = appFileNo;
	}
	public String getResultFileName() {
		return resultFileName;
	}
	public void setResultFileName(String resultFileName) {
		this.resultFileName = resultFileName;
	}
	public String getResultFileNo() {
		return resultFileNo;
	}
	public void setResultFileNo(String resultFileNo) {
		this.resultFileNo = resultFileNo;
	}
	
}
