package com.stackroute.customerservice.userservice.controller;

import com.stackroute.customerservice.userservice.dto.AddUser;
import com.stackroute.customerservice.userservice.dto.UserDetails;
import com.stackroute.customerservice.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class RegistrationController {
    private IUserService service;

    @Autowired
    public RegistrationController(IUserService service) {
        this.service = service;
    }



    //    /products/add
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public UserDetails register(@RequestBody AddUser requestData) throws Exception {
        return service.register(requestData);
    }

    @GetMapping("/byname/{username}")
    public UserDetails findByUserName(@PathVariable String username) throws Exception {
        UserDetails response = service.findByUsername(username);
        return response;
    }







}
