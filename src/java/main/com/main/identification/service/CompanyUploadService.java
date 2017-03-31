package com.main.identification.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.Company;
import com.main.identification.repository.CompanyRepository;
import com.main.identification.utils.Constant;

@Service
public class CompanyUploadService {
	
	@Autowired
	public CompanyRepository companyRepository;
	

	public void insertCompanyBatch(List<Company> companyLst){
		companyRepository.insertCompanyBatch(companyLst);
	}
	/**
	 * 文件上传单位
	 * @param 文件内容集合
	 */
	public void uploadCompany(List<Map<String,String>> pioFileLst){
		// 文件中的单位名
		Set<String> fileCompanyName = new HashSet<String>();
		// 单位集合
		List<Company> companyLst = new ArrayList<Company>();
		// 取出文档中单位名称集合
		for(Map<String,String> pioFile : pioFileLst){
			fileCompanyName.addAll(Arrays.asList(pioFile.get("company").split(Constant.splitConstant)));
		}
		// 创建要插入的单位集合
		for(String companyName : fileCompanyName){
			if(isNewCompany(companyName)){
				Company company = new Company();
				company.setCompanyName(companyName);
				company.setCompanyType("0");
				companyLst.add(company);
			}
		}
		// 插入新的单位
		if(companyLst != null && companyLst.size() > 0){
			companyRepository.insertCompanyBatch(companyLst);
		}
	}
	
	/**
	 * 单位名称是否存在
	 * @param 单位名称
	 */
	private Boolean isNewCompany(String companyName){
		Boolean result = true;
		Company company = companyRepository.searchCompanyByName(companyName);
		if(company != null && company.getCompanyCode() != null){
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * @param companyMap
	 */
	public void addCompanyModel(HashMap<String, String> companyMap) {
		// 文件中的单位名
		Set<String> fileCompanyName = new HashSet<String>();
		// 取得每行的公司名称，按照分隔符分割，去重
		for (Map.Entry<String, String> entry : companyMap.entrySet()) {
			fileCompanyName.addAll(Arrays.asList(entry.getValue().split(Constant.splitConstant)));
        }
		// 单位集合
		List<Company> companyLst = new ArrayList<Company>();
	
		// 创建要插入的单位集合
		for(String companyName : fileCompanyName){
			if(isNewCompany(companyName)){
				Company company = new Company();
				company.setCompanyNo("");
				company.setCompanyName(companyName);
				company.setCompanyType("0");
				companyLst.add(company);
			}
		}
		// 插入新的单位
		if(companyLst != null && companyLst.size() > 0){
			companyRepository.insertCompanyBatch(companyLst);
		}	
	}
	public void insertCompany(Company company) {
		companyRepository.insertCompany(company);
	}
	public void deleteCompanyByCondation(Company company) {
		companyRepository.deleteCompany(company);
	}
}