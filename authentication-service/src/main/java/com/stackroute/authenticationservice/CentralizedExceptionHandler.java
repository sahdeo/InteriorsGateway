package com.stackroute.authenticationservice;

import com.stackroute.authenticationservice.exception.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidCredentialsException.class,
            MethodArgumentNotValidException.class
    })
    public String handleInvalidArgument(Exception e) {
        return "Invalid arguments";
    }

}
