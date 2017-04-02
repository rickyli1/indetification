package com.main.identification.model;

import java.util.List;

public class ApplicationRequstModel {
	private List<ConstantModel> repairLevels;
	private List<Expert> experts;
	private List<EquipmentModel> equipments;
	public List<ConstantModel> getRepairLevels() {
		return repairLevels;
	}
	public void setRepairLevels(List<ConstantModel> repairLevels) {
		this.repairLevels = repairLevels;
	}
	public List<Expert> getExperts() {
		return experts;
	}
	public void setExperts(List<Expert> experts) {
		this.experts = experts;
	}
	public List<EquipmentModel> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<EquipmentModel> equipments) {
		this.equipments = equipments;
	}
}
