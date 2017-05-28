package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.EquipmentModel;
import com.main.identification.model.EquipmentResult;

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

	public int batchAddEquipmentModel(List<EquipmentModel> equipmentList);

	public List<EquipmentResult> selectEquipmentList(EquipmentResult equipmentModel);

	public int selectEquipmentResultCount(EquipmentResult equipment);
	

	public int selectEquipmentCount(EquipmentResult equipment);


	public List<EquipmentResult> searchEquipmentList2(EquipmentResult equipment);

	public List<EquipmentResult> searchEquipmentListExport(
			EquipmentResult equipment);

	public List<EquipmentModel> findEquipmentList(EquipmentModel equipmentModel);

	public EquipmentResult selectEquipmentInfoByNo(String equipmentNo);

}
