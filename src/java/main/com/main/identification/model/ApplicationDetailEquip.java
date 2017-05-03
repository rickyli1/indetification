package com.main.identification.model;

import java.io.Serializable;

/**
 * 申请详情_设备Model
 * @author YangQi
 *
 */
public class ApplicationDetailEquip extends BaseModel implements Serializable {

	private static final long serialVersionUID = 2134063410803358370L;
	// 设备类别编号
	private String groupNo;
	// 设备类别名称
	private String groupName;
	// 子类别编号
	private String subGroupNo;
	// 子类别名称
	private String subGroupName;
	// 设备编号
	private String equipmentNo;
	// 设备名称
	private String equipmentName;
	// 维修级别
	private String repairLevel;
	// 结果
	private String result;
	// 是否整改
	private String isReform;
	// 有效期
	private String timeLimit;
	// 备注
	private String remark;
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSubGroupNo() {
		return subGroupNo;
	}
	public void setSubGroupNo(String subGroupNo) {
		this.subGroupNo = subGroupNo;
	}
	public String getSubGroupName() {
		return subGroupName;
	}
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
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
	public String getIsReform() {
		return isReform;
	}
	public void setIsReform(String isReform) {
		this.isReform = isReform;
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
	
}
