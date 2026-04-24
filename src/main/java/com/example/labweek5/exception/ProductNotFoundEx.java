package com.example.labweek5.exception;

public class ProductNotFoundEx extends RuntimeException {
    public ProductNotFoundEx(String message) {
        super(message);
    }
}
