package com.pws.CompanyEmployee.serviceImp;

import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.exception.IdNotFoundException;
import com.pws.CompanyEmployee.exception.InvalidEntryException;
import com.pws.CompanyEmployee.exception.NoDataAvailableException;
import com.pws.CompanyEmployee.repository.EmployeeRepository;
import com.pws.CompanyEmployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.time.Month;
import java.util.*;


import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        repository.save(employee);
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Employee Id not found");
        }
        Employee emp = optional.get();
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setEmail(employee.getEmail());
        emp.setDob(employee.getDob());
        emp.setPincode(employee.getPincode());
        emp.setSalary(employee.getSalary());
        repository.save(emp);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Employee ID Not Found");
        }
        return optional.get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = repository.findAll();
        if (employees == null) {
            throw new NoDataAvailableException("NO DATA AVAILABLE TO DISPLAY");
        }
        return employees;
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Employee id not found");
        }
        repository.delete(optional.get());
    }

    public List<Employee> sortAndLength() {
        List<Employee> emp = repository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        return emp;
    }

    @Override
    public Page<Employee> sortSalary(int number) {
        Page<Employee> employees = repository.findAll(PageRequest.of(number, 1).withSort(Sort.by(Sort.Direction.DESC,"salary")));
        return employees;
    }

    public List<Employee> compareSalary(double salary, String value){
        if (value == ">") {
            List<Employee> emp = repository.salaryGreaterThan(salary);
            return emp;
        } else if (value == "<") {
            List<Employee> emp2 = repository.salaryLessThan(salary);
            return emp2;
        } else if (value == "=") {
            List<Employee> emp3 =repository.salaryEqual(salary);
            return emp3;
        } else {
            throw new InvalidEntryException("Invalid input");
        }
    }

    @Override
    public List<Employee> byMonth(int month) {
        List<Employee> employees = repository.findAll();
        Iterator<Employee> iterator = employees.iterator();
        List<Employee> employee = new ArrayList<>();
        while (iterator.hasNext()){
            Employee e = iterator.next();
            int mon = e.getDob().getMonth();
            if(mon == month){
                employee.add(e);
            }
        }
        return employee;
    }

    public List<Employee> byAlphabet(char ch){
        List<Employee> emp = repository.byAlphabet(ch);
        return emp;
    }
}