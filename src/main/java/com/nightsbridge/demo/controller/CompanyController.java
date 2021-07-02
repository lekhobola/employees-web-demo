/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.controller;

import com.nightsbridge.demo.exception.ResourceNotFoundException;
import com.nightsbridge.demo.model.Company;
import com.nightsbridge.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Company controller.
 *
 * @author Lekhobola Tsoeunyane
 */
@RestController
@RequestMapping("employees-demo/api/v1")
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  /**
   * Get all companies list.
   *
   * @return the list
   */
  @GetMapping("/companies")
  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  /**
   * Gets companies by id.
   *
   * @param companyId the company id
   * @return the companies by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/companies/{id}")
  public ResponseEntity<Company> getCompaniesById(@PathVariable(value = "id") Long companyId)
      throws ResourceNotFoundException {
    Company company =
        companyRepository
            .findById(companyId)
            .orElseThrow(() -> new ResourceNotFoundException("Company not found on :: " + companyId));
    return ResponseEntity.ok().body(company);
  }

  /**
   * Create company company.
   *
   * @param company the company
   * @return the company
   */
  @PostMapping("/companies")
  public Company createUser(@Valid @RequestBody Company company) {
    return companyRepository.save(company);
  }

  /**
   * Update company response entity.
   *
   * @param companyId the company id
   * @param companyDetails the company details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/companies/{id}")
  public ResponseEntity<Company> updateUser(
      @PathVariable(value = "id") Long companyId, @Valid @RequestBody Company companyDetails)
      throws ResourceNotFoundException {

    Company company =
        companyRepository
            .findById(companyId)
            .orElseThrow(() -> new ResourceNotFoundException("Company not found on :: " + companyId));

    company.setName(companyDetails.getName());
    company.setVatNumber(companyDetails.getVatNumber());
    company.setAddressPhysical(companyDetails.getAddressPhysical());
    company.setAddressPostal(companyDetails.getAddressPostal());
    company.setTelephoneNumber(companyDetails.getTelephoneNumber());
    final Company updatedUser = companyRepository.save(company);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete company map.
   *
   * @param companyId the company id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/companies/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long companyId) throws Exception {
    Company company =
        companyRepository
            .findById(companyId)
            .orElseThrow(() -> new ResourceNotFoundException("Company not found on :: " + companyId));

    companyRepository.delete(company);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
