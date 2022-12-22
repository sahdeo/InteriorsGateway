package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.UserDao;
import com.stackroute.authenticationservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerNewUser(User user) {
        user.setUserName(user.getUserName());
        user.setRole(user.getRole());
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}