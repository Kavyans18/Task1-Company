package com.pws.CompanyEmployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class EmployeeCompany implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "employee_id")
        @JsonIgnore
        private Employee employee;

        @ManyToOne
        @JsonIgnore
        @JoinColumn(name = "company_id")
        private Company company;

}
