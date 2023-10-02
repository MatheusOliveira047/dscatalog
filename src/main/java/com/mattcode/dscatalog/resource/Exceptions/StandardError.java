package com.mattcode.dscatalog.resource.Exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    public StandardError(){

    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public StandardError setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public StandardError setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public StandardError setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public StandardError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath(String requestURI) {
        return path;
    }

    public StandardError setPath(String path) {
        this.path = path;
        return this;
    }
}
