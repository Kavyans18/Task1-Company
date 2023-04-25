package com.pws.CompanyEmployee.service;

import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.entity.EmployeeCompany;
import com.pws.CompanyEmployee.repository.EmployeeCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeCompanyService {

    EmployeeCompany save(EmployeeCompany empcmp, int empId, int compId);

    EmployeeCompany update(EmployeeCompany empcmp, int id);

    EmployeeCompany getById(int id);

    List<EmployeeCompany> getAll();

    void delete(int id);

}
