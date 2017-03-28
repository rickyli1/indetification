package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.Expert;

/**
 * 专家Repository
 * 
 * @author YangQi
 */
public interface ExpertRepository {
	/**
	 * 专家检索
	 * @param expert 检索条件
	 * @return 结果集
	 */
	public List<Expert> selectExpert(Expert expert);

	/**
	 * 主键检索
	 * @param expertNo 专家编号PK
	 * @return 专家
	 */
	public Expert selectByPK(String expertNo);

	/**
	 * 专家插入
	 * @param expert 专家信息
	 * @return 
	 */
//	public int insertExpert(Expert expert);

	/**
	 * 专家更新
	 * @param expert 专家信息
	 * @return 
	 */
//	public int updateExpert(Expert expert);
	
}
