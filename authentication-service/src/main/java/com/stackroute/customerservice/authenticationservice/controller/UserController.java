package com.stackroute.customerservice.authenticationservice.controller;

<<<<<<< HEAD:authentication-service/src/main/java/com/stackroute/customerservice/authenticationservice/controller/UserController.java
import com.stackroute.customerservice.authenticationservice.dto.JwtRequest;
import com.stackroute.customerservice.authenticationservice.dto.JwtResponse;
import com.stackroute.customerservice.authenticationservice.entity.User;
import com.stackroute.customerservice.authenticationservice.service.JwtServiceImp;
import com.stackroute.customerservice.authenticationservice.service.UserServiceImp;
=======
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.service.UserService;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:authentication-service/src/main/java/com/stackroute/authenticationservice/controller/UserController.java
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
