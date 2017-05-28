package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.ApplicationDetailComp;
import com.main.identification.model.ApplicationDetailExpert;
import com.main.identification.model.Expert;
import com.main.identification.model.ExpertCond;

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
	 * 注册页面用专家数量
	 * @param expert 检索条件
	 * @return 结果集
	 */
	public int selectExperCountForApplication(Expert expert);	
	
	/**
	 * 申请注册页面用
	 * @param expert 检索条件
	 * @return 结果集
	 */	
	public List<Expert> selectExpertForApplication(Expert expert);

	/**
	 * 主键检索
	 * @param expertNo 专家编号PK
	 * @return 专家
	 */
	public Expert selectByPK(String expertNo);
	
	/**
	 * 详情画面，取得专家信息部分
	 * @param condition
	 * @return
	 */
	public List<ApplicationDetailExpert> searchAppExpertDetail(ApplicationDetailComp condition);

	public List<Expert> checkExpertExistCompany(ExpertCond expert);
	
	/**
	 * 专家插入
	 * @param expert 专家信息
	 * @return 
	 */
	public int insertExpert(Expert expert);
	
	/**
	 * 删除专家
	 * @param expert 专家信息
	 * @return
	 */
	public int delUpdateExpert(Expert expert);

	/**
	 * 专家更新
	 * @param expert 专家信息
	 * @return 
	 */
	public int updateExpert(Expert expert);
	
}
