package com.stockroute.designerservice.designer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ProfileAlreadyExit.class)
    public ResponseEntity<Object> exception(ProfileAlreadyExit ex){
        return new ResponseEntity<>("Id Already Exists", HttpStatus.FOUND);
    }

    @ExceptionHandler (ResourceNotFound.class)
    public ResponseEntity<Object> exception(ResourceNotFound exe){
        return new ResponseEntity<>("Id does not exist",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler (IdNotFound.class)
    public ResponseEntity<Object> exception(IdNotFound exe){
        return new ResponseEntity<>("Data not found for this Id",HttpStatus.NOT_FOUND);
    }
}