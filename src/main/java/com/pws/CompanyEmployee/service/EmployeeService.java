package com.pws.CompanyEmployee.service;

import com.pws.CompanyEmployee.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, int id);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void deleteEmployee(int id);

    List<Employee>sortAndLength();

    Page<Employee> sortSalary (int number);

    List<Employee> compareSalary(double salary, String value);

    List<Employee>byMonth(int month);

    List<Employee> byAlphabet(char ch);


}
