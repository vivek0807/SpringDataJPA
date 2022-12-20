package com.example.springdatajpa.Exception;

import org.springframework.stereotype.Component;


public class CustomerNotFoundException extends RuntimeException{

    String Message;

    public CustomerNotFoundException(String message) {
        Message = message;
    }


}
