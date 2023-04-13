package com.pws.CompanyEmployee.controller;

import com.pws.CompanyEmployee.entity.Company;
import com.pws.CompanyEmployee.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ConcurrentModificationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;

    @PostMapping("/save")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        service.saveCompany(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company,@PathVariable int id){
        service.updateCompany(company, id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
        Company company = service.getCompanyById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companies = service.getAllCompany();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable int id){
        service.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
