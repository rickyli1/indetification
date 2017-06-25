package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.ConstantModel;

/**
 * 
 * @author duqiao
 *
 */
public interface ConstantRepository {
	
	public List<ConstantModel> selectConstantList(ConstantModel constant);

	/**
	 * @return
	 */
	public int insertConstant(ConstantModel constant);

	/**
	 * @return
	 */
	public int updateConstant(ConstantModel constant);
	
	
	public void deleteConstant(ConstantModel constant);

	public int findParentSeq();

	public int findChildrenSeq();
	
	public int batchAddConstantModel(List<ConstantModel> constantList);
	
	public int findEquipmentSeq();

	public int findCompanySeq();
	
	public int findReportSeq();

	public int findApplicationSeq();

	public List<ConstantModel> findConstantMap(ConstantModel constantModel);
	
	// 画面用
	public int searchConstantCount(ConstantModel constant);
	
	public List<ConstantModel> searchConstantList(ConstantModel constant);
	
	public int deleteConstantList(List<ConstantModel> constantList);
	
	public int updateOneConstant(ConstantModel constant);

	public List<ConstantModel> searchConstant(ConstantModel constantModel);
	
	public int searchConstantCountForAdd(ConstantModel constant);

}
