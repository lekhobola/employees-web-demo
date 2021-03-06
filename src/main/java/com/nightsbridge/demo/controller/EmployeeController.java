/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.controller;

import com.nightsbridge.demo.exception.ResourceNotFoundException;
import com.nightsbridge.demo.model.Employee;
import com.nightsbridge.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Employee controller.
 *
 * @author Lekhobola Tsoeunyane
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("employees-demo/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get all employees list.
     *
     * @return the list
     */
    @GetMapping("/employees")
    public List<Employee> getAllCompanies() {
        return employeeRepository.findAll();
    }

    /**
     * Gets employees by id.
     *
     * @param employeeId the employee id
     * @return the employees by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getCompaniesById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee
                = employeeRepository
                        .findById(employeeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    /**
     * Create employee employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @PostMapping("/employees")
    public Employee createUser(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Update employee response entity.
     *
     * @param employeeId the employee id
     * @param employeeDetails the employee details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateUser(
            @PathVariable(value = "id") Long employeeId, @Valid @RequestBody Employee employeeDetails)
            throws ResourceNotFoundException {

        Employee employee
                = employeeRepository
                        .findById(employeeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + employeeId));

        employee.setEmployeeNumber(employeeDetails.getEmployeeNumber());
        employee.setNames(employeeDetails.getNames());
        employee.setLastName(employeeDetails.getLastName());
        employee.setIdentityNumber(employeeDetails.getIdentityNumber());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setAddressPhysical(employeeDetails.getAddressPhysical());
        employee.setAddressPostal(employeeDetails.getAddressPostal());
        employee.setTelephoneNumber(employeeDetails.getTelephoneNumber());
        final Employee updatedUser = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete employee map.
     *
     * @param employeeId the employee id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long employeeId) throws Exception {
        Employee employee
                = employeeRepository
                        .findById(employeeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
