package com.stackroute.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Already Exists")
public class UserNotFoundException extends Exception {


    public UserNotFoundException(String msg) {
        super(msg);
    }


}
