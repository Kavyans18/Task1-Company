package com.pws.CompanyEmployee.repository;

import com.pws.CompanyEmployee.entity.Company;
import com.pws.CompanyEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
