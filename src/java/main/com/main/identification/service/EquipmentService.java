package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.EquipmentModel;
import com.main.identification.model.EquipmentResult;
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

	public List<EquipmentModel> findEquipmentList(EquipmentModel equipmentModel) {
		return equipmentRepository.findEquipmentList(equipmentModel);
	}
	
	/**
	 * 单表查询语句
	 * @param equipmentModel
	 * @return
	 */
	public List<EquipmentResult> findEquipmentList2(EquipmentResult equipmentResult) {
		return equipmentRepository.selectEquipmentList(equipmentResult);
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

	public int selectEquipmentResultCount(EquipmentResult equipment) {
		return equipmentRepository.selectEquipmentResultCount(equipment);
	}
	
	public int selectEquipmentCount(EquipmentResult equipment) {
		return equipmentRepository.selectEquipmentCount(equipment);
	}

	public List<EquipmentResult> searchEquipmentList(EquipmentResult equipment) {
		return equipmentRepository.searchEquipmentList2(equipment);
	}

	public List<EquipmentResult> exportEquipmentList(EquipmentResult equipment) {
		return equipmentRepository.searchEquipmentListExport(equipment);
	}

	public int updateEquipment(EquipmentModel equipmentModel) {
		return equipmentRepository.updateEquipment(equipmentModel);
	}

	public EquipmentResult selectEquipmentInfoByNo(String equipmentNo) {
		return equipmentRepository.selectEquipmentInfoByNo(equipmentNo);
	}
	
}
