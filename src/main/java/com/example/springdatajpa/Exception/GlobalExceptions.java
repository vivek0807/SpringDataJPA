package com.example.springdatajpa.Exception;

import com.example.springdatajpa.Entity.Customer;
import com.example.springdatajpa.Service.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<Object> customerNotFoundHandler(CustomerNotFoundException ex){
        System.out.println("Coming till here");
        ApiResponse apiResponse=new ApiResponse(ex.getMessage(),false);
        return new ResponseEntity<>(apiResponse.toString(),HttpStatus.NOT_FOUND);
    }
   /* @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ApiResponse> NumberFormatExceptionhadler(NumberFormatException ex){
        System.out.println("Coming till here");
        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.NOT_FOUND);
    }*/
}
