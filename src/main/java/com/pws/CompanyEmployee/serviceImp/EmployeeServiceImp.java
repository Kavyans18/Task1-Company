package com.pws.CompanyEmployee.serviceImp;

import com.pws.CompanyEmployee.entity.Company;
import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.exception.IdNotFoundException;
import com.pws.CompanyEmployee.exception.NoDataAvailableException;
import com.pws.CompanyEmployee.repository.CompanyRepository;
import com.pws.CompanyEmployee.repository.EmployeeRepository;
import com.pws.CompanyEmployee.service.CompanyService;
import com.pws.CompanyEmployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

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
        emp.setCompanies(employee.getCompanies());
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

    @Override
    public List<String> sortAndLength() {
        List<Employee> employees = repository.findAll();
        Iterator<Employee> iterator = employees.iterator();
        List<String> str = new ArrayList<>();
        while(iterator.hasNext()){
            str.add(iterator.next().getName());
        }
        Collections.sort(str, Comparator.comparingInt(String::length));
        return str;
    }

    @Override
    public List<String> fetchWithAlphabet(String alphabet){
        List<String> names = sortAndLength();
        alphabet.toUpperCase();
        names = names.stream().filter(s->s.startsWith(alphabet)).collect(Collectors.toList());
        return names;
    }

    @Override
    public Employee sortSalary(int number) {
        List<Employee>employees = repository.findAll();
        Optional<Employee> emp = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(number-1).findFirst();
        return emp.get();
    }

    @Override
    public List<Employee> salaryGreaterThan(double salary) {
        List<Employee> employees = repository.salaryGreaterThan(salary);
        return employees;
    }

    @Override
    public List<Employee> salaryLesserThan(double salary){
        List<Employee> employees = repository.salaryLessThan(salary);
        return employees;
    }

    @Override
    public List<Employee> salaryEquals(double salary) {
        List<Employee>employees = repository.salaryEqual(salary);
        return employees;
    }

    @Override
    public List<Employee> byMonth(int month) {
        List<Employee> employees = repository.byMonth(month);
        return employees;
    }
}
