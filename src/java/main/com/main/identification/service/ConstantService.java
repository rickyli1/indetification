package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.ConstantModel;
import com.main.identification.repository.ConstantRepository;

/**
 * 
 * @author duqiao
 *
 */
@Service
public class ConstantService {
	@Autowired
	private ConstantRepository constantRepository;


	/**
	 * @param adminUser
	 */
	public int addConstantModel(ConstantModel constant) {
		return constantRepository.insertConstant(constant);
	}

	public int findParentSeq(){
		return constantRepository.findParentSeq();
	}
	public int findChildrenSeq(){
		return constantRepository.findChildrenSeq();
	}
//	/**
//	 * @param adminUser
//	 */
//	public int modifyAdminUser(AdminUser adminUser) {
//		return adminUserRepository.updateAdminUser(adminUser);
//	}

	public int batchAddConstantModel(List<ConstantModel> constantList) {
		return constantRepository.batchAddConstantModel(constantList);
	}
}
