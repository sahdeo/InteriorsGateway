package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import rabbitmq.domain.EmailDto;
import rabbitmq.domain.UserDto;

public interface IUserService {
    User registerNewUser(User user);
    User findByUsername(String userName) throws UserNotFoundException;
    EmailDto forgotPassword(String emailId) throws UserNotFoundException;

}
