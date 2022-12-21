package com.stackroute.authenticationservice.controller;

import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser(){
        userService.initRoleAndUser();
    }

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user) throws Exception{
        return userService.registerNewUser(user);
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }
    @GetMapping("/login")
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

}
