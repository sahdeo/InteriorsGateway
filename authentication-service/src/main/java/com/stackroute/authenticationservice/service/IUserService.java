package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;

public interface IUserService {
    User registerNewUser(User user);
    User findByUsername(String userName) throws UserNotFoundException;
    String forgotPassword(String emailId) throws UserNotFoundException;

}
