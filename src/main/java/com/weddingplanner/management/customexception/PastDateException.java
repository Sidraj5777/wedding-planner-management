package com.weddingplanner.management.customexception;

public class PastDateException extends RuntimeException {
    public PastDateException(String message) {
        super(message);
    }
}