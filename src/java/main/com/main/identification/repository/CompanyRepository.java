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

	public int deleteCompany(Company company);
	
	public int deleteOneCompany(Company company);
	
	public List<Company> selectCompanyResultList(Company company);
	
	public int selectCompanyResultCount(Company company);
	
	public int updateCompany(Company company);
	
	public List<Company> selectCompany(Company company);
	
	public int selectCompanyResultCountForAdd(Company company);
}
