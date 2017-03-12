package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.EquipmentModel;

/**
 * 
 * @author duqiao
 *
 */
public interface EquipmentRepository {
	
	public List<EquipmentModel> selectEquipment(EquipmentModel equipment);

	/**
	 * @return
	 */
	public int insertEquipment(EquipmentModel equipment);

	/**
	 * @return
	 */
	public int updateEquipment(EquipmentModel equipment);
	
	
	public void deleteEquipment(EquipmentModel equipment);

}
