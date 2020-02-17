/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception.
 *
 * @author Lekhobola Tsoeunyane
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    /**
     * Initializes a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
