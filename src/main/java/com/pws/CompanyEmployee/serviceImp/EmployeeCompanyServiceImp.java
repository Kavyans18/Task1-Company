package com.pws.CompanyEmployee.serviceImp;

import com.pws.CompanyEmployee.entity.Company;
import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.entity.EmployeeCompany;
import com.pws.CompanyEmployee.exception.IdNotFoundException;
import com.pws.CompanyEmployee.exception.NoDataAvailableException;
import com.pws.CompanyEmployee.repository.CompanyRepository;
import com.pws.CompanyEmployee.repository.EmployeeCompanyRepository;
import com.pws.CompanyEmployee.repository.EmployeeRepository;
import com.pws.CompanyEmployee.service.EmployeeCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeCompanyServiceImp implements EmployeeCompanyService {

    private final EmployeeCompanyRepository repository;

    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;

    @Override
    public EmployeeCompany save(EmployeeCompany empcmp, int empId, int compId) {
        Optional<Employee> emp = employeeRepository.findById(empId);
        Optional<Company> comp = companyRepository.findById(compId);
        if (emp.isEmpty() || comp.isEmpty()) {
            throw new NoDataAvailableException("Objects of company or employee unavailable");
        }
        empcmp.setCompany(comp.get());
        empcmp.setEmployee(emp.get());
        repository.save(empcmp);
        return empcmp;
    }

    @Override
    public EmployeeCompany update(EmployeeCompany empcmp, int id) {
        Optional<EmployeeCompany> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid reference ID");
        }
        EmployeeCompany ec = optional.get();
        ec.setEmployee(empcmp.getEmployee());
        ec.setCompany(empcmp.getCompany());
        return ec;
    }

    @Override
    public EmployeeCompany getById(int id) {
        Optional<EmployeeCompany> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid reference ID");
        }
        return optional.get();
    }

    @Override
    public List<EmployeeCompany> getAll() {
        List<EmployeeCompany> list = repository.findAll();
        return list;
    }

    @Override
    public void delete(int id) {
        Optional<EmployeeCompany> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid reference ID");
        }
        repository.delete(optional.get());
    }
}
