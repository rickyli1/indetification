package com.main.identification.model;

import java.util.List;

public class EqupmentRequstModel {
	private List<ConstantModel> repairLevels;
	private List<ConstantModel> parentConstants;
	private List<ConstantModel> childrenConstants;
	
	public List<ConstantModel> getRepairLevels() {
		return repairLevels;
	}
	public void setRepairLevels(List<ConstantModel> repairLevels) {
		this.repairLevels = repairLevels;
	}
	public List<ConstantModel> getParentConstants() {
		return parentConstants;
	}
	public void setParentConstants(List<ConstantModel> parentConstants) {
		this.parentConstants = parentConstants;
	}
	public List<ConstantModel> getChildrenConstants() {
		return childrenConstants;
	}
	public void setChildrenConstants(List<ConstantModel> childrenConstants) {
		this.childrenConstants = childrenConstants;
	}
	
}
