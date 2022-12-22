package com.stockroute.designerservice.design.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "design already exists")
public class DesignAlreadyExistsException extends Exception {

}
