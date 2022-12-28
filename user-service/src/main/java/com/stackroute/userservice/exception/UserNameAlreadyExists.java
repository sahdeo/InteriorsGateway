package com.stackroute.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Already Exists")
public class UserNameAlreadyExists extends Exception{
    public UserNameAlreadyExists(String msg){
        super(msg);
    }
}
