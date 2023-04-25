package com.pws.CompanyEmployee.exception;

public class NoDataAvailableException extends RuntimeException{
    String message = "NO DATA AVAILABLE IN DATABASE";

    public NoDataAvailableException(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
