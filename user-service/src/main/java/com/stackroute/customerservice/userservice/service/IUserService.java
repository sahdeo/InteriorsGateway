package com.stackroute.customerservice.userservice.service;

import com.stackroute.customerservice.userservice.exception.EmailAlreadyExists;
import com.stackroute.customerservice.userservice.exception.InvalidArgumentException;
import com.stackroute.customerservice.userservice.exception.UserNotFoundException;
import com.stackroute.customerservice.userservice.dto.AddUser;
import com.stackroute.customerservice.userservice.dto.UserDetails;
import com.stackroute.customerservice.userservice.exception.PasswordDoesNotMatchException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface IUserService {
    UserDetails register(@Valid AddUser requestData) throws InvalidArgumentException, EmailAlreadyExists, UserNotFoundException, PasswordDoesNotMatchException;

    UserDetails findByUsername(String username) throws InvalidArgumentException,  UserNotFoundException;

    UserDetails findByEmail(String email) throws InvalidArgumentException,UserNotFoundException;


}
