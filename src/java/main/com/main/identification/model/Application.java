package com.main.identification.model;

import java.io.Serializable;

public class Application extends BaseModel implements Serializable {

	private static final long serialVersionUID = 3795786639519832181L;
	private String applicationNo; // 申请编号
	private String applicationDate; // 申请日期YYYYMMDD
	private String companyNo; // 单位编号
	private String department; // 主要代表机构或装备部门
	private String originFlag;// 来源Flag
	private String remark; // 备注
	
	private String appFileName; //申请文本名
	private String appFileNo;   //申请文本编号
	private String resultFileName; //结论文本文件名
	private String  resultFileNo; //结论文本文件编号
	
	private String  leaderNo; //专家组长编号
    private String  expertsNo;//专家编号集合
	
	private String deleteFlag = "0";     //删除Flag
	private String createBy;       //创建人
	private String  lastModifyBy;  //最后修改人
	
	private String companyName;
	private String expertsName;
	
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

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

	public String getOriginFlag() {
		return originFlag;
	}

	public void setOriginFlag(String originFlag) {
		this.originFlag = originFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExpertsName() {
		return expertsName;
	}

	public void setExpertsName(String expertsName) {
		this.expertsName = expertsName;
	}
}
