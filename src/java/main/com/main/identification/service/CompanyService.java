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
}
