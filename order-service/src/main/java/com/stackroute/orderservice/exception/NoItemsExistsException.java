package com.stackroute.orderservice.exception;

public class NoItemsExistsException extends Exception{
    public NoItemsExistsException(String msg){
        super(msg);
    }
}
