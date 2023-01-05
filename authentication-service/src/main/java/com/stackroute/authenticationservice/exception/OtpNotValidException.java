package com.stackroute.authenticationservice.exception;

public class OtpNotValidException extends Exception{
    public OtpNotValidException(String msg){
        super(msg);
    }
}
