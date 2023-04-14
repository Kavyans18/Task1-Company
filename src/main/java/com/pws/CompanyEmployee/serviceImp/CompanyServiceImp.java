package com.pws.CompanyEmployee.serviceImp;

import com.pws.CompanyEmployee.entity.Company;
import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.exception.IdNotFoundException;
import com.pws.CompanyEmployee.exception.NoDataAvailableException;
import com.pws.CompanyEmployee.repository.CompanyRepository;
import com.pws.CompanyEmployee.repository.EmployeeRepository;
import com.pws.CompanyEmployee.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository repository;

    private final EmployeeRepository repo;

    @Override
    public Company saveCompany(Company company) {
        repository.save(company);
        return company;
    }

    @Override
    public Company updateCompany(Company company, int id) {
        Optional<Company> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Company Id");
        }
        Company comp = optional.get();
        comp.setName(company.getName());
        comp.setEmail(company.getEmail());
        comp.setPhoneNumber(company.getPhoneNumber());
        comp.setAddress(company.getAddress());
        //comp.setEmployee(company.getEmployee());
        repository.save(comp);
        return comp;
    }

    @Override
    public Company getCompanyById(int id) {
        Optional<Company> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("Invalid Company Id");
        }
        return optional.get();
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company> company = repository.findAll();
        if(company == null){
            throw new NoDataAvailableException("Data unavailable");
        }
        return company;
    }

    @Override
    public void deleteCompany(int id) {
        Optional<Company> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("Company ID Not Found");
        }
        repository.delete(optional.get());
    }
}
