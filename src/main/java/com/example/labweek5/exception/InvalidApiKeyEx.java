package com.example.labweek5.exception;

public class InvalidApiKeyEx  extends RuntimeException{
    public InvalidApiKeyEx(String message){
        super(message);
    }
}
