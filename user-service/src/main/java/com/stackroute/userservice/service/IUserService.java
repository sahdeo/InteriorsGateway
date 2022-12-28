package com.stackroute.userservice.service;

import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UpdateEmailDto;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.exception.EmailAlreadyExists;
import com.stackroute.userservice.exception.InvalidArgumentException;
import com.stackroute.userservice.exception.PasswordDoesNotMatchException;
import com.stackroute.userservice.exception.UserNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface IUserService {
    UserDetails register(@Valid AddUser requestData) throws InvalidArgumentException, EmailAlreadyExists, UserNotFoundException, PasswordDoesNotMatchException;

    UserDetails findByUsername(String username) throws InvalidArgumentException,  UserNotFoundException;

    UserDetails findByEmail(String email) throws InvalidArgumentException,UserNotFoundException;

    UserDetails updateEmail(@Valid UpdateEmailDto requestData) throws UserNotFoundException;
    
    List<UserDetails> fetchAll();
}
