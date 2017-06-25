package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.Company;
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

    public List<ConstantModel>findConstantList(ConstantModel constant) {
    	return constantRepository.selectConstantList(constant);
    }
	
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

	public void deleteConstantsByCondation(ConstantModel constant) {
		constantRepository.deleteConstant(constant);
	}
	
	public int searchConstantCount(ConstantModel constant){
		return constantRepository.searchConstantCount(constant);
	}
	
	public List<ConstantModel> searchConstantList(ConstantModel constant){
		return constantRepository.searchConstantList(constant);
	}
	
	public int deleteConstantList(List<ConstantModel> constantList){
		return constantRepository.deleteConstantList(constantList);
	}
	
	public int updateConstant(ConstantModel constant){
		return constantRepository.updateOneConstant(constant);
	}

	public List<ConstantModel> searchConstant(ConstantModel constantModel) {

		return constantRepository.searchConstant(constantModel);
	}
	
	public int searchConstantCountForAdd(ConstantModel constant){
		return constantRepository.searchConstantCountForAdd(constant);
	}
}
