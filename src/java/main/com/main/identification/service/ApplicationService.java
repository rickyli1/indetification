package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.repository.ApplicationRepository;
import com.main.identification.model.ApplicationResult;

/**
 * 申请管理Service
 * 
 * @author YangQi
 *
 */
@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
	/**
	 * 申请查询
	 * 
	 * @param condition 检索条件
	 * @return 结果集
	 */
	public List<ApplicationResult> searchList(ApplicationResult condition){
		condition.setPageSize(10);
		condition.setStartNo(0);
		return applicationRepository.selectApplicationResultList(condition);
	}
	
	/**
	 * 申请查询
	 * 
	 * @param condition 检索条件
	 * @return 结果集
	 */
	public int selectApplicationResultCount(ApplicationResult condition){
		return applicationRepository.selectApplicationResultCount(condition);
	}

}
