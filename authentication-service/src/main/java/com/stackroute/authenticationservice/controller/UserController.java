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
import org.springframework.web.bind.annotation.*;
import rabbitmq.domain.UserDto;

@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private JwtServiceImp jwtServiceImp;


    @PostMapping(value = "/registerNewUser")
    public ResponseEntity<User> registerNewUser(@RequestBody User user){
         userServiceImp.registerNewUser(user);
         return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createJwtToken(@RequestBody UserDto user) throws Exception {
        JwtRequest jwtRequest = new JwtRequest(user.getEmailId(), user.getUserPassword());
       // userServiceImp.registerNewUser(user);
        JwtResponse jwtResponse = jwtServiceImp.createJwtToken(jwtRequest);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping("/loginCustomer")
    @PreAuthorize("hasRole('CUSTOMER')")

    public String forUser(){
        return "This URL is only accessible to the Customer";
    }
    @GetMapping("/loginDesigner")
    @PreAuthorize("hasRole('DESIGNER')")
    public String forDesigner(){
        return "This URL is only accessible to the Designer";
    }
}



