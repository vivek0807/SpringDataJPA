package com.example.springdatajpa.Service;

public class ApiResponse {
    String message;
    boolean State;

    public ApiResponse(String message, boolean state) {
        this.message = message;
        State = state;
    }

    @Override
    public String toString() {
        return message+" "+State;
    }
}
