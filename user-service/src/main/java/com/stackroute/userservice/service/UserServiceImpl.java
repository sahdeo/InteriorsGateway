package com.stackroute.userservice.service;


import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UpdateEmailDto;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.User;
import com.stackroute.userservice.exception.*;
import com.stackroute.userservice.repository.IUserRepository;
import com.stackroute.userservice.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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
       MobileNoValidator(requestData.getMobileNo());
        User user = new User();
        user.setUserName(requestData.getUserName().trim());
        user.setEmailId(requestData.getEmailId().trim().toString());
        user.setPassword(passwordEncoder.encode(requestData.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(requestData.getConfirmPassword()));
        user.setMobileNo(requestData.getMobileNo());
        user.setRole(requestData.getRole());
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
    public UserDetails findByEmail(String email) throws InvalidArgumentException, UserNotFoundException {
        Optional<User> optional = userrepo.findByEmailId(email);
        if(optional.isEmpty()){
            throw new UserNotFoundException("User not found by emailId= "+email);
        }
        return userUtil.toUserDetails(optional.get());
    }

    @Override
    public UserDetails updateEmail(UpdateEmailDto requestData) throws UserNotFoundException {
        User user = findByusername(requestData.getUsername().trim());
        user.setEmailId(requestData.getNewEmail());
        user = userrepo.save(user);
        UserDetails desired = userUtil.toUserDetails(user);
        return desired;
    }


    public User findByusername(String username) throws UserNotFoundException {
        Optional<User> optional = userrepo.findByUserName(username.trim());
        if(optional.isEmpty()){
            throw new UserNotFoundException("Username not found");

        }
        User user = optional.get();
        return user;
    }

    public void PasswordAuthentication(String password, String ConfirmPassword) throws PasswordDoesNotMatchException {
        if(password.equalsIgnoreCase(ConfirmPassword)){
            return;
        }
        else {
            throw new PasswordDoesNotMatchException("Password and ConfirmPassword Fields does not match");
        }

    }

    public List<UserDetails> fetchAll(){
        List<User> users = userrepo.findAll();
        List<UserDetails> desired = userUtil.toUserDetailsList(users);
        return desired;

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void MobileNoValidator(String mobileNo){
        if (mobileNo.length()==10){
            return;
        }
        else new MobileNoNotValidException("Mobile number is less that 10 digits Please enter valid mobile number");
    }

}
