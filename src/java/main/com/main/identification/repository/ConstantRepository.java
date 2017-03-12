package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.ConstantModel;

/**
 * 
 * @author duqiao
 *
 */
public interface ConstantRepository {
	
	public List<ConstantModel> selectConstant(ConstantModel constant);

	/**
	 * @return
	 */
	public int insertConstant(ConstantModel constant);

	/**
	 * @return
	 */
	public int updateConstant(ConstantModel constant);
	
	
	public void deleteConstant(ConstantModel constant);

}
