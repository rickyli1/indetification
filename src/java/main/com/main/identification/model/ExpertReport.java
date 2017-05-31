package com.main.identification.model;

import java.io.Serializable;

public class ExpertReport extends Report implements Serializable {

	private static final long serialVersionUID = -6506701389579541028L;
	private String reportCompanyName; // 被审单位
	private String repairLevelName; // 维修级别
	private String role; // 担任角色
	public String getReportCompanyName() {
		return reportCompanyName;
	}
	public void setReportCompanyName(String reportCompanyName) {
		this.reportCompanyName = reportCompanyName;
	}
	public String getRepairLevelName() {
		return repairLevelName;
	}
	public void setRepairLevelName(String repairLevelName) {
		this.repairLevelName = repairLevelName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
