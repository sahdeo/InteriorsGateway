package com.stackroute.customerservice.userservice.exception;

public class UserNameAlreadyExists extends Exception{
    public UserNameAlreadyExists(String msg){
        super(msg);
    }
}
