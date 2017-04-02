package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.EquipmentModel;
import com.main.identification.repository.EquipmentRepository;

/**
 * 
 * @author duqiao
 * @createtime 2017-03-16
 */
@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<EquipmentModel> findEquipmentList() {
		return equipmentRepository.selectEquipmentList();
	}

	public int addEquipmentModel(EquipmentModel equipment) {
		return equipmentRepository.insertEquipment(equipment);
	}


	public int batchAddEquipmentModel(List<EquipmentModel> equipmentList) {
		return equipmentRepository.batchAddEquipmentModel(equipmentList);
	}


	public void deleteEquipByCondation(EquipmentModel equip) {
		equipmentRepository.deleteEquipment(equip);		
	}
	
}
