/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.repository;

import com.nightsbridge.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lekhobola Tsoeunyane
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {}