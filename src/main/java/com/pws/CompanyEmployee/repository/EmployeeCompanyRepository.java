package com.pws.CompanyEmployee.repository;

import com.pws.CompanyEmployee.entity.EmployeeCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCompanyRepository extends JpaRepository<EmployeeCompany, Integer> {

}
