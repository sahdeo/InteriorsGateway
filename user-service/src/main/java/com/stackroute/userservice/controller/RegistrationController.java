package com.stackroute.userservice.controller;

import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UpdateEmailDto;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.User;
import com.stackroute.userservice.exception.InvalidArgumentException;
import com.stackroute.userservice.exception.UserNotFoundException;
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

    @GetMapping("/byname/{username}")
    public UserDetails findByUserName(@PathVariable String username) throws Exception {
        UserDetails response = service.findByUsername(username);
        return response;
    }

    @GetMapping("/byemail/{emailID}")
    public User findByEmailId(@PathVariable String emailID) throws Exception {
        User response = service.findByEmail(emailID);
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

   @DeleteMapping("/removeUser/{userName}")
    public Boolean remove(@PathVariable String userName) throws UserNotFoundException, InvalidArgumentException {
        return service.deleteUserByUsername(userName);
    }
}

