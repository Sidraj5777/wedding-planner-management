package com.weddingplanner.management.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEventDateException extends RuntimeException {
    public InvalidEventDateException(String message) {
        super(message);
    }
}