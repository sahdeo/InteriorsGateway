package com.stackroute.authenticationservice.controller;

import com.stackroute.authenticationservice.dto.JwtRequest;
import com.stackroute.authenticationservice.dto.JwtResponse;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.service.JwtServiceImp;
import com.stackroute.authenticationservice.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private JwtServiceImp jwtServiceImp;


    @PostMapping("/registerNewUser")
    public ResponseEntity<User> registerNewUser(@RequestBody User user){
         user = userServiceImp.registerNewUser(user);
         return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping({"/authenticate"})
    public ResponseEntity<JwtResponse> createJwtToken(@RequestBody User user) throws Exception {
        JwtRequest jwtRequest = new JwtRequest(user.getUserName(), user.getUserPassword());
       // userServiceImp.registerNewUser(user);
        JwtResponse jwtResponse = jwtServiceImp.createJwtToken(jwtRequest);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}



