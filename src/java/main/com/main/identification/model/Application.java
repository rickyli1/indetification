package com.main.identification.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Application extends BaseModel implements Serializable {

	private static final long serialVersionUID = 6040568253512679000L;
	private String applicationNo; // 申请编号
	private String applicationDate; // 申请日期YYYYMMDD
	private String companyNo; // 单位编号
	private String department; // 主要代表机构或装备部门
	private String appFilePath; // 申请文本文件路径
	private String resultFildPath; // 结论文本文件路径
	private String remark; // 备注
	
	private String deleteFlag = "0";     //删除Flag
	private String createBy;       //创建人
	private String  lastModifyBy;  //最后修改人
	private Timestamp createTime;  //创建时间
	private Timestamp lastModifyTime; //最后修改时间
	
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
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
