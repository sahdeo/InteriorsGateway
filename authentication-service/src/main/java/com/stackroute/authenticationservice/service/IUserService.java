package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.exception.UserAlredyExistException;
import com.stackroute.authenticationservice.entity.User;

public interface IUserService {
    public void initRoleAndUser();
    User registerNewUser(User user) throws UserAlredyExistException;
}
