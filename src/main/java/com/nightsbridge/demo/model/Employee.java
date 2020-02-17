/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Lekhobola Tsoeunyane
 */
@Entity
@Table(name = "tb_employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee extends Person implements Serializable {

    @Column(name = "employee_number", nullable = false)
    private String employeeNumber;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    /**
     * Gets the employee number
     *
     * @return the employee number
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Sets the employee number
     *
     * @param employeeNumber the employee number
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Gets the company
     *
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the company
     *
     * @param company the company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ""
                + ", employeeNumber=" + employeeNumber + ""
                + ", company=" + company
                + '}';
    }

}
