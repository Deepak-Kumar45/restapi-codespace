package com.spring.restapi_codespace.exceptionhandling;

public class GenericExceptionHandling {
    private String timestamp;
    private String message;
    private String details;
    
 public GenericExceptionHandling() {
    }
  
    public GenericExceptionHandling(String timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
   
}
