package com.stackroute.userservice.service;


import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.User;
import com.stackroute.userservice.exception.EmailAlreadyExists;
import com.stackroute.userservice.exception.InvalidArgumentException;
import com.stackroute.userservice.exception.PasswordDoesNotMatchException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.IUserRepository;
import com.stackroute.userservice.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserUtil userUtil;

    @Autowired
    public UserServiceImpl(IUserRepository userrepo , UserUtil userUtil){
        this.userrepo=userrepo;
        this.userUtil=userUtil;
    }

    private Random random=new Random();


    @Override
    public UserDetails register(AddUser requestData) throws EmailAlreadyExists, UserNotFoundException, PasswordDoesNotMatchException, InvalidArgumentException {
        PasswordAuthentication(requestData.getPassword(),requestData.getConfirmPassword());
        User user = new User();
        user.setUserName(requestData.getUserName());
        user.setEmailId(requestData.getEmailId());
        user.setPassword(passwordEncoder.encode(requestData.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(requestData.getConfirmPassword()));
        user.setMobileNo(requestData.getMobileNo());
        //user.setRole(userUtil.getRoleType(requestData.getRole()));
        Optional<User> userentry = userrepo.findByUserName(user.getUserName());
        Optional<User> userEmail = userrepo.findByEmailId(user.getEmailId());
        if(userentry.isPresent()){
            throw new UserNotFoundException("Username already exists !!");
        } else if (userEmail.isPresent()) {
            throw new EmailAlreadyExists("Email Id already Exists !!");
        }
        user=userrepo.save(user);
        UserDetails desired=userUtil.toUserDetails(user);
        return desired;
    }


    @Override
    public UserDetails findByUsername(String username) throws  UserNotFoundException {

        Optional<User> optional = userrepo.findByUserName(username);
        if(optional.isEmpty()){
            throw new UserNotFoundException("user not found by username= "+username);
        }
        return userUtil.toUserDetails(optional.get());
    }

    @Override
    public UserDetails findByEmail(String email) throws  UserNotFoundException {
        Optional<User> optional = userrepo.findByEmailId(email);
        if(optional.isEmpty()){
            throw new UserNotFoundException("User not found by emailId= "+email);
        }
        return userUtil.toUserDetails(optional.get());
    }



    public void PasswordAuthentication(String password, String ConfirmPassword) throws PasswordDoesNotMatchException {
        if(password.equalsIgnoreCase(ConfirmPassword)){
            return;
        }
        else {
            throw new PasswordDoesNotMatchException("Password and ConfirmPassword Fields does not match");
        }

    }


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
