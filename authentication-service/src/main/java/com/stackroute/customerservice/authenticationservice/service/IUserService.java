package com.stackroute.customerservice.authenticationservice.service;

import com.stackroute.customerservice.authenticationservice.entity.User;
import com.stackroute.customerservice.authenticationservice.exception.UserNotFoundException;

public interface IUserService {
    User registerNewUser(User user);
    User findByUsername(String userName) throws UserNotFoundException;

}
