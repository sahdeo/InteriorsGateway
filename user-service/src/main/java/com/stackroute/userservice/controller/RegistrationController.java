package com.stackroute.userservice.controller;

import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UpdateEmailDto;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class RegistrationController {
    private IUserService service;

    private ResponseEntity responseEntity;

    @Autowired
    public RegistrationController(IUserService service) {
        this.service = service;
    }

    @PostMapping(value = "/register")
    public UserDetails register(@RequestBody AddUser requestData) throws Exception {
        return service.register(requestData);
    }

    @GetMapping("/byName/{username}")
    public UserDetails findByUserName(@PathVariable String username) throws Exception {
        UserDetails response = service.findByUsername(username);
        return response;
    }

    @GetMapping("/byEmail/{emailId}")
    public UserDetails findByEmailId(@PathVariable String emailId) throws Exception {
        UserDetails response = service.findByEmail(emailId);
        return response;
    }

    @GetMapping("/fetchUsers")
    public List<UserDetails> fetchAll() {
        List<UserDetails> response = service.fetchAll();
        return response;
    }

    @PutMapping("/change/Email")
    public UserDetails updateEmailId(@RequestBody UpdateEmailDto requestData) throws Exception {
        UserDetails response = service.updateEmail(requestData);
        return response;
    }

   @DeleteMapping("/removeUser/{emailID}")
    public Boolean remove(@PathVariable String emailID){
        return service.DeleteEmailId(emailID);
    }
}

