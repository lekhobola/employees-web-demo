/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Lekhobola Tsoeunyane
 */
@Entity
@Table(name = "tb_company")
@EntityListeners(AuditingEntityListener.class)
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vat_number", nullable = false)
    private String vatNumber;

    @Column(name = "address_physical", nullable = false)
    private String addressPhysical;

    @Column(name = "address_postal", nullable = false)
    private String addressPostal;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    /**
     * Gets the id
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the VAT number
     *
     * @return the VAT number
     */
    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * Sets the VAT number
     *
     * @param vatNumber the VAT number
     */
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * Gets the physical address
     *
     * @return the physical address
     */
    public String getAddressPhysical() {
        return addressPhysical;
    }

    /**
     * Set the physical address
     *
     * @param addressPhysical the physical address
     */
    public void setAddressPhysical(String addressPhysical) {
        this.addressPhysical = addressPhysical;
    }

    /**
     * Gets the postal address
     *
     * @return the postal address
     */
    public String getAddressPostal() {
        return addressPostal;
    }

    /**
     * Sets the postal address
     *
     * @param addressPostal the postal address
     */
    public void setAddressPostal(String addressPostal) {
        this.addressPostal = addressPostal;
    }

    /**
     * Gets the telephone number
     *
     * @return the telephone number
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the telephone number
     *
     * @param telephoneNumber the telephone number
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<Employee> getEmployees() {
        //return employees;
        return null;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{"
                + "id=" + id + ""
                + ", name=" + name + ""
                + ", vatNumber=" + vatNumber + ""
                + ", addressPhysical=" + addressPhysical + ""
                + ", addressPostal=" + addressPostal + ""
                + ", telephoneNumber=" + telephoneNumber + ""
                + ", employees=" + employees
                + '}';
    }

}
