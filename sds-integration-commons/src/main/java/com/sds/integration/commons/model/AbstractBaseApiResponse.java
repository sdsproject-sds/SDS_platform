package com.sds.integration.commons.model;


import java.time.Instant;

/**
 * @author Joseph.Kibe. Created On 11 Apr 2026 20:42
 */

public abstract class AbstractBaseApiResponse<T> {

    private boolean success;
    private String responseCode;
    private String responseMessage;
    private String responseDescription;
    private String errorReference;
    private T data;
    private Instant timestamp;


    protected AbstractBaseApiResponse() {
        this.timestamp = Instant.now();
    }

    protected AbstractBaseApiResponse(boolean success, String responseCode, String responseMessage,
                                      String responseDescription, String errorReference, T data,
                                      Instant timestamp) {
        this.success = success;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseDescription = responseDescription;
        this.errorReference = errorReference;
        this.data = data;
        this.timestamp = timestamp;
    }

    protected AbstractBaseApiResponse(T data, boolean success) {
        this.success = success;
        this.responseCode = success ? "SUCCESS" : "ERROR";
        this.responseMessage = success ? "Success" : "Error";
        this.timestamp = Instant.now();
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getErrorReference() {
        return errorReference;
    }

    public void setErrorReference(String errorReference) {
        this.errorReference = errorReference;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Success response
     */
    protected AbstractBaseApiResponse<T> success(String code, String message, T data) {

        this.success = true;
        this.responseCode = code;
        this.responseMessage = message;
        this.data = data;
        return this;
    }

    /**
     * Error response with error reference
     */
    public AbstractBaseApiResponse<T> error(String code, String message, String description, String errorReference) {
        this.success = false;
        this.responseCode = code;
        this.responseMessage = message;
        this.responseDescription = description;
        this.errorReference = errorReference;
        return this;
    }

    /**
     * Error response without error reference (for backward compatibility)
     */
    public AbstractBaseApiResponse<T> error(String code, String message, String description) {
        return error(code, message, description, null);
    }
}
