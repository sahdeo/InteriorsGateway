package com.stockroute.designerservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "product with the specified id not found")
public class DesignNotFoundException  extends Exception{
}
