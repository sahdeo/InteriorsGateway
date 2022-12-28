package com.stackroute.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Order can't be empty")
public class OrderIsNull extends Exception{
    public OrderIsNull(String msg){
        super(msg);
    }
}
