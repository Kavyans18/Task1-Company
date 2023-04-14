package com.pws.CompanyEmployee.exception;

public class InvalidEntryException extends RuntimeException {

    String message = "Invalid input";

    public InvalidEntryException(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
