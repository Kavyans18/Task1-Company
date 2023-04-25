package com.pws.CompanyEmployee.service;

import com.pws.CompanyEmployee.entity.Company;
import com.pws.CompanyEmployee.entity.Employee;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    Company updateCompany(Company company, int id);

    Company getCompanyById(int id);

    List<Company> getAllCompany();

    void deleteCompany(int id);

}
