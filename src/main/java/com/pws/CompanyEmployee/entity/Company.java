package com.pws.CompanyEmployee.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "phone_number", nullable = false, unique = true)
    @Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits")
    private long phoneNumber;
}
