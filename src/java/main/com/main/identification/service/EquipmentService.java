package com.main.identification.service;

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


	/**
	 * @param adminUser
	 */
	public int addEquipmentModel(EquipmentModel equipment) {
		return equipmentRepository.insertEquipment(equipment);
	}
	
//	/**
//	 * @param adminUser
//	 */
//	public int modifyAdminUser(AdminUser adminUser) {
//		return adminUserRepository.updateAdminUser(adminUser);
//	}
}
