package com.main.identification.model;

import java.io.Serializable;

public class Report extends BaseModel implements Serializable{

	private static final long serialVersionUID = -2368897972554206520L;
	private String reportNo; // 历史编号
	private String companyNo; // 单位编号
	private String leaderNo; // 专家组长编号
	private String expertsNo; // 专家编号集合
	private String equipmentNo; // 设备编号
	private String repairLevel; // 申请的修理等级
	private String applicationNo; // 申请编号
	private String applicationDate; // 申请日期YYYYMMDD
	private String result; // 结果
	private String timeLimit; // 有效期限
	private String isReform; // 是否整改
	private String remark; // 备注
	
	public String getReportNo() {
		return reportNo;
	}
	
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
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

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getRepairLevel() {
		return repairLevel;
	}

	public void setRepairLevel(String repairLevel) {
		this.repairLevel = repairLevel;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getIsReform() {
		return isReform;
	}

	public void setIsReform(String isReform) {
		this.isReform = isReform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
