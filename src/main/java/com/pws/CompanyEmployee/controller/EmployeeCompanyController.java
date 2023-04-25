package com.pws.CompanyEmployee.controller;

import com.pws.CompanyEmployee.entity.EmployeeCompany;
import com.pws.CompanyEmployee.service.EmployeeCompanyService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empcomp")
public class EmployeeCompanyController {

   private final EmployeeCompanyService service;

    @PostMapping("/save/{empId}/{compId}")
    public ResponseEntity<EmployeeCompany> save(@RequestBody EmployeeCompany employeeCompany, @PathVariable int empId, @PathVariable int compId){
        service.save(employeeCompany, empId, compId);
        return new ResponseEntity<>(employeeCompany, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeCompany> update(@RequestBody EmployeeCompany employeeCompany,@PathVariable int id) {
        service.update(employeeCompany, id);
        return new ResponseEntity<>(employeeCompany, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeCompany> getById(@PathVariable int id){
        EmployeeCompany ec = service.getById(id);
        return new ResponseEntity<>(ec, HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<EmployeeCompany>> getAll(){
        List<EmployeeCompany> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeCompany>delete(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
