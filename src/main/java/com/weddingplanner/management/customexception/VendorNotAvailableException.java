package com.weddingplanner.management.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VendorNotAvailableException extends RuntimeException {
    public VendorNotAvailableException(String message) {
        super(message);
    }
}
