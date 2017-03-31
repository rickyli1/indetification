package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.repository.ExpertRepository;
import com.main.identification.model.Expert;

/**
 * 专家Service
 * 
 * @author YangQi
 *
 */
@Service
public class ExpertService {
	@Autowired
	private ExpertRepository expertRepository;
	
	/**
	 * 申请查询
	 * 
	 * @param condition 检索条件
	 * @return 结果集
	 */
	public Expert selectByExpertNo(String expertNo){
		return expertRepository.selectByPK(expertNo);
	}

	/**
	 * 检索专家姓名
	 * @param expert 专家内容
	 * @return
	 */
	public List<Expert> selectExpert(Expert expert){
		return expertRepository.selectExpert(expert);
	}
}
