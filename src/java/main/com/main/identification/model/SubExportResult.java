package com.main.identification.model;

import java.io.Serializable;

public class SubExportResult extends BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 331030060448044924L;

//	REPAIR_LEVEL	申请的修理等级
	private String repairLevel;
	private String repairName;

//	TIME_LIMIT	有效期限
	private String timeLimit;

//	REMARK	备注
	private String remark;
	
//	COMPANY_NAME	单位名称
	private String companyNames;
//	EQUIPMENT_NO	设备编号
	private String equipmentNo;

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

	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCompanyNames() {
		return companyNames;
	}

	public void setCompanyNames(String companyNames) {
		this.companyNames = companyNames;
	}
	
	
}
