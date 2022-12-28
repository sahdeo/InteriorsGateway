package com.stackroute.customerservice.authenticationservice.controller;

import com.stackroute.customerservice.authenticationservice.entity.User;
import com.stackroute.customerservice.authenticationservice.exception.UserNotFoundException;
import com.stackroute.customerservice.authenticationservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgetPassword {
    @Autowired
    private IUserService userService;
    public String forgotPassword(String username) throws UserNotFoundException {
        User user = userService.findByUsername(username);
        return null;
    }
}
