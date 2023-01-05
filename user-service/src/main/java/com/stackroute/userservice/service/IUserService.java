package com.stackroute.userservice.service;

import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UpdateEmailDto;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.User;
import com.stackroute.userservice.exception.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface IUserService {
    UserDetails register(@Valid AddUser requestData) throws InvalidArgumentException, EmailAlreadyExists, UserNotFoundException, PasswordDoesNotMatchException, MobileNoNotValidException;

    UserDetails findByUsername(String username) throws InvalidArgumentException,  UserNotFoundException;

    User findByEmail(String email) throws InvalidArgumentException,UserNotFoundException;

    UserDetails updateEmail(@Valid UpdateEmailDto requestData) throws UserNotFoundException, InvalidArgumentException;
    
    List<UserDetails> fetchAll();

   boolean deleteUserByUsername(String username) throws UserNotFoundException, InvalidArgumentException;
}
