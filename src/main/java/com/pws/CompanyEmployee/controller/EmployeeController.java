package com.pws.CompanyEmployee.controller;

import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.exception.InvalidEntryException;
import com.pws.CompanyEmployee.service.EmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        service.updateEmployee(employee, id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = service.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> sortAndLength() {
        List<Employee> emp = service.sortAndLength();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("compare/{salary}/{value}")
    public ResponseEntity<List<Employee>> salaryCompare(@PathVariable double salary,@PathVariable String value) {
        List<Employee> employees = service.compareSalary(salary, value);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<List<Employee>> byMonth(@PathVariable int month) {
        List<Employee> employees = service.byMonth(month);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/ch/{ch}")
    public ResponseEntity<List<Employee>> byAlphabet(@PathVariable char ch) {
        List<Employee> emp = service.byAlphabet(ch);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
