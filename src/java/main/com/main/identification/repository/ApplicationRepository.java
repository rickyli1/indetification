package com.main.identification.repository;

import java.util.List;

import com.main.identification.model.Application;
import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.ApplicationDetailComp;
import com.main.identification.model.ApplicationDetailEquip;
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
	
	public int updateApplication(Application application);
	
	/**
	 * @return
	 */
	public int deleteApplication(Application application);
	
	/**
	 * @return
	 */
	public int delUpdateApplication(Application application);
	
	/**
	 * 根据申请编号，获取详细画面单位信息部分
	 * @param condition
	 * @return
	 */
	public ApplicationDetailComp selectCompDetailByApplication(String applicationNo);
	
	/**
	 * 根据申请编号，获取详细画面设备信息部分
	 * @param condition
	 * @return
	 */
	public List<ApplicationDetailEquip> selectEquipsDetailByApplication(String applicationNo);
	
	public ApplicationAddModel selectApplicationInfoByNo(String id);
}
