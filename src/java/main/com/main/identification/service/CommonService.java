package com.main.identification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.repository.CommonRepository;



@Service
public class CommonService {
	
	@Autowired
	private CommonRepository commonRepository;
	
	//获得序列值
	public int createSequenceId(String sequenceName) {
		return commonRepository.selectSequenceId(sequenceName);
	}
}
