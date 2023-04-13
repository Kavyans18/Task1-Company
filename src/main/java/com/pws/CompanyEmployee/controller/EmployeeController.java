package com.pws.CompanyEmployee.controller;

import com.pws.CompanyEmployee.entity.Employee;
import com.pws.CompanyEmployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<String>> sortAndLength() {
        List<String> str = service.sortAndLength();
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/alphabet/{alphabet}")
    public ResponseEntity<List<String>> fetchWithAlphabet(@PathVariable String alphabet) {
        List<String> names = service.fetchWithAlphabet(alphabet);
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/sal/{num}")
    public ResponseEntity<Employee> sortSalary(@PathVariable int num) {
        Employee emp = service.sortSalary(num);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/greater/{salary}")
    public ResponseEntity<List<Employee>> salaryGreaterThan(@PathVariable double salary) {
        List<Employee> employees = service.salaryGreaterThan(salary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("lesser/{salary}")
    public ResponseEntity<List<Employee>> salaryLesserThan(@PathVariable double salary) {
        List<Employee> employees = service.salaryLesserThan(salary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/equals/{salary}")
    public ResponseEntity<List<Employee>> salaryEqualsTo(@PathVariable double salary) {
        List<Employee> employees = service.salaryEquals(salary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<List<Employee>> byMonth(@PathVariable int month){
        List<Employee> employees = service.byMonth(month);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
