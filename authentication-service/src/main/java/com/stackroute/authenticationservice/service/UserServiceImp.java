package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.IUserDao;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.Optional;


@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerNewUser(User user) {
        user.setUserName(user.getUserName());
        user.setRole(user.getRole());
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    @Override
    public User findByUsername(String userName) throws UserNotFoundException {
        Optional<User> optional = userDao.findById(userName);
        if(optional.isEmpty()){
            throw new UserNotFoundException("usranme is missing");
        }
        return optional.get();
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}