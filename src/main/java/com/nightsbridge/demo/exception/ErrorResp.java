/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nightsbridge.demo.exception;

import java.util.Date;

/**
 * The type Error response.
 *
 * @author Lekhobola Tsoeunyane
 */
public class ErrorResp {

    private Date timestamp;
    private String status;
    private String message;

    /**
     * Initializes a new Error response.
     *
     * @param timestamp the timestamp
     * @param status the status
     * @param message the message
     */
    public ErrorResp(Date timestamp, String status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
