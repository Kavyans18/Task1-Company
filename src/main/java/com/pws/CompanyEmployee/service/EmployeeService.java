package com.pws.CompanyEmployee.service;

import com.pws.CompanyEmployee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, int id);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void deleteEmployee(int id);

    List<String>sortAndLength();

    List<String> fetchWithAlphabet(String alphabet);

    Employee sortSalary (int number);

    List<Employee> salaryGreaterThan(double number);

    List<Employee> salaryLesserThan(double salary);

    List<Employee> salaryEquals(double salary);

    List<Employee>byMonth(int month);

}
