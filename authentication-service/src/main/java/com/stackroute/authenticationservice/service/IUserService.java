package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.entity.User;

public interface IUserService {
    User registerNewUser(User user);
}
