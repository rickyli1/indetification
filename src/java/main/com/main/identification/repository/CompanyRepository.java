package com.main.identification.repository;
import java.util.List;

import com.main.identification.model.Company;

public interface CompanyRepository {
	
	public List<Company> selectCompanyList(Company company);
	/**
	 * @return
	 */
	public int insertCompany(Company company);

	public int insertCompanyBatch(List<Company> list);
	
	public Company searchCompanyByName(String companyName);

	public void deleteCompany(Company company);
}
