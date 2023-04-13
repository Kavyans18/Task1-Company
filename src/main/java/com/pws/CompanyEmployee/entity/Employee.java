package com.pws.CompanyEmployee.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "salary")
    private double salary;
    @Column(name = "pin_code", nullable = false)
    private long pincode;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "date_of_birth", nullable = false)
    private Date dob;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Company> companies;
}
