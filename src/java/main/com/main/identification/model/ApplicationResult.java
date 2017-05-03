package com.main.identification.model;

import java.io.Serializable;

/**
 * 申请结果查询界面Vo
 * @author YangQi
 *
 */
public class ApplicationResult extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = 7564825956587460831L;
	//	APPLICATION_NO	申请编号
	private String applicationNo;
//	APPLICATION_DATE	申请日期
	private String applicationDate;
//	申请日期From
	private String applicationDateFrom;
//	申请日期To
	private String applicationDateTo;
//	REPORT_NO	历史编号
	private String reportNo;
//	COMPANY_NO	单位编号
	private String companyNo;
//	COMPANY_NAME	单位名称
	private String companyName;
//	LEADER_NO	专家组长编号
	private String leaderNo;
//	LEADER_NAME	专家组长姓名
	private String leaderName;
//	EXPERTS_NO	专家编号集合
	private String expertsNo;
//	EXPERT_NAME	专家组姓名集合
	private String expertsName;
	// 画面检索条件，专家姓名
	private String expertNameCon;
//	EQUIPMENT_NO	设备编号
	private String equipmentNo;
//	EQUIPMENT_NAME	设备名称
	private String equipmentName;
//	REPAIR_LEVEL	申请的修理等级
	private String repairLevel;
//	RESULT	结果
	private String result;
//	TIME_LIMIT	有效期限
	private String timeLimit;
//	IS_REFORM	是否整改
	private String isReform;
	// 来源Flag
	private String originFlag;
//	REMARK	备注
	private String remark;
	
	private String resultCon;
	
	private String repairLevelCon;
	
	private String limitDateCon;
	
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
	public String getApplicationDateFrom() {
		return applicationDateFrom;
	}
	public void setApplicationDateFrom(String applicationDateFrom) {
		this.applicationDateFrom = applicationDateFrom;
	}
	public String getApplicationDateTo() {
		return applicationDateTo;
	}
	public void setApplicationDateTo(String applicationDateTo) {
		this.applicationDateTo = applicationDateTo;
	}
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLeaderNo() {
		return leaderNo;
	}
	public void setLeaderNo(String leaderNo) {
		this.leaderNo = leaderNo;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getExpertsNo() {
		return expertsNo;
	}
	public void setExpertsNo(String expertsNo) {
		this.expertsNo = expertsNo;
	}
	public String getExpertsName() {
		return expertsName;
	}
	public void setExpertsName(String expertsName) {
		this.expertsName = expertsName;
	}
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getRepairLevel() {
		return repairLevel;
	}
	public void setRepairLevel(String repairLevel) {
		this.repairLevel = repairLevel;
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
	public String getExpertNameCon() {
		return expertNameCon;
	}
	public void setExpertNameCon(String expertNameCon) {
		this.expertNameCon = expertNameCon;
	}
	public String getResultCon() {
		return resultCon;
	}
	public void setResultCon(String resultCon) {
		this.resultCon = resultCon;
	}
	public String getRepairLevelCon() {
		return repairLevelCon;
	}
	public void setRepairLevelCon(String repairLevelCon) {
		this.repairLevelCon = repairLevelCon;
	}
	public String getLimitDateCon() {
		return limitDateCon;
	}
	public void setLimitDateCon(String limitDateCon) {
		this.limitDateCon = limitDateCon;
	}
}
