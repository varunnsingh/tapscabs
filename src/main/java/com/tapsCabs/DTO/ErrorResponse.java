package com.tapsCabs.DTO;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote general error response for all exceptions
 */

public class ErrorResponse {
    private String requestedResource;
    private String logRef;
    private String message;
    private String typeOfException;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String timeStamp;

    public String getRequestedResource() {
        return requestedResource;
    }

    public void setRequestedResource(String requestedResource) {
        this.requestedResource = requestedResource;
    }

    public String getLogRef() {
        return logRef;
    }

    public void setLogRef(String logRef) {
        this.logRef = logRef;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeOfException() {
        return typeOfException;
    }

    public void setTypeOfException(String typeOfException) {
        this.typeOfException = typeOfException;
    }
}
