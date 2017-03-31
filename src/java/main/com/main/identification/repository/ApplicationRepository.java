package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.Application;
import com.main.identification.model.ApplicationResult;

/**
 * 申请管理Repository
 * 
 * @author YangQi
 *
 */
public interface ApplicationRepository {
	/**
	 * 申请结果查询
	 * 
	 * @param condition 申请检索条件
	 * @return 结果集
	 */
	public List<ApplicationResult> selectApplicationResultList(ApplicationResult condition);
	
	/**
	 * 申请结果查询记录数
	 * 
	 * @param condition 申请检索条件
	 * @return 结果记录数
	 */
	public int selectApplicationResultCount(ApplicationResult condition);
	
	/**
	 * @return
	 */
	public int insertApplication(Application application);
	
	/**
	 * @return
	 */
	public int deleteApplication(Application application);
}
