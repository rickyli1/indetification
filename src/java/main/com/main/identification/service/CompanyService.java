package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.Company;
import com.main.identification.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	public CompanyRepository companyRepository;
	
	public List<Company> findCompanyList(Company company) {
		return companyRepository.selectCompanyList(company);
	}
	
	public List<Company> selectCompanyResultList(Company company){
		return companyRepository.selectCompanyResultList(company);
	}

	public int selectCompanyResultCount(Company company){
		return companyRepository.selectCompanyResultCount(company);
	}
	
	public int addCompany(Company company){
		return companyRepository.insertCompany(company);
	}
	
	public int deleteCompany(Company company){
		return companyRepository.deleteOneCompany(company);
	}
	
	public int updateCompany(Company company){
		return companyRepository.updateCompany(company);
	}
	
	public List<Company> selectCompany(Company company){
		return companyRepository.selectCompany(company);
	}
	
	public int selectCompanyResultCountForAdd(Company company){
		return companyRepository.selectCompanyResultCountForAdd(company);
	}
}
