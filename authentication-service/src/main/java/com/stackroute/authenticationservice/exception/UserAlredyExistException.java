package com.stackroute.authenticationservice.exception;

public class UserAlredyExistException extends Exception{
    public UserAlredyExistException(String msg){
        super(msg);
    }
}
