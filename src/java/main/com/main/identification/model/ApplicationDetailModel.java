package com.main.identification.model;

import java.io.Serializable;
import java.util.List;

/**
 * 申请详情Model
 * @author YangQi
 *
 */
public class ApplicationDetailModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3503280583305486978L;
	// 申请代号
	private String applicationNo;
	// 申请代号
	private ApplicationDetailComp company;
	// 组长信息
	private ApplicationDetailExpert leader;
	// 专家列表
	private List<ApplicationDetailExpert> experts;
	// 设备列表
	private List<ApplicationDetailEquip> equipments;
	
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public ApplicationDetailComp getCompany() {
		return company;
	}
	public void setCompany(ApplicationDetailComp company) {
		this.company = company;
	}
	public ApplicationDetailExpert getLeader() {
		return leader;
	}
	public void setLeader(ApplicationDetailExpert leader) {
		this.leader = leader;
	}
	public List<ApplicationDetailExpert> getExperts() {
		return experts;
	}
	public void setExperts(List<ApplicationDetailExpert> experts) {
		this.experts = experts;
	}
	public List<ApplicationDetailEquip> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<ApplicationDetailEquip> equipments) {
		this.equipments = equipments;
	}
	
}
