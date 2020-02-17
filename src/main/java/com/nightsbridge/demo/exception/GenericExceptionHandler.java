/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * The type Generic exception handler.
 *
 * @author Lekhobola Tsoeunyane
 */
@ControllerAdvice
public class GenericExceptionHandler {

    /**
     * Resource not found exception response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        ErrorResp errorDetails
                = new ErrorResp(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Generic exception handler response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericExcpetionHandler(Exception ex, WebRequest request) {
        ErrorResp errorDetails
                = new ErrorResp(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
