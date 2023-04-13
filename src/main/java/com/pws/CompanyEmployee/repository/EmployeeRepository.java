package com.pws.CompanyEmployee.repository;

import com.pws.CompanyEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.salary >:salary")
    List<Employee> salaryGreaterThan(double salary);

    @Query("select e from Employee e where e.salary <:salary")
    List<Employee> salaryLessThan(double salary);


    @Query("select e from Employee e where e.salary =:salary")
    List<Employee>salaryEqual(double salary);

    @Query(value = "select * form Employee e where e.dob LIKE %month%", nativeQuery = true)
    List<Employee>byMonth(int month);

}
