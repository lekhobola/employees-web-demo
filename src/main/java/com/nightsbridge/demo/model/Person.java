/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Lekhobola Tsoeunyane
 */
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "names", nullable = false)
    protected String names;

    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Column(name = "identity_number", nullable = false)
    protected String identityNumber;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    protected Date dateOfBirth;

    @Column(name = "address_physical", nullable = false)
    protected String addressPhysical;

    @Column(name = "address_postal", nullable = false)
    protected String addressPostal;

    @Column(name = "telephone_number", nullable = false)
    protected String telephoneNumber;

    /**
     * Gets id
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
     * Gets the names
     *
     * @return the names
     */
    public String getNames() {
        return names;
    }

    /**
     * Sets the names
     *
     * @param names the names
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     * Gets the last name
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the identity number
     *
     * @return the identity number
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * Set the identity number
     *
     * @param identityNumber the identity number
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     * Gets the date of birth
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
     * Sets the physical address
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

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id + ""
                + ", names=" + names + ""
                + ", lastName=" + lastName + ""
                + ", identityNumber=" + identityNumber + ""
                + ", dateOfBirth=" + dateOfBirth + ""
                + ", addressPhysical=" + addressPhysical + ""
                + ", addressPostal=" + addressPostal + ""
                + ", telephoneNumber=" + telephoneNumber
                + '}';
    }

}
