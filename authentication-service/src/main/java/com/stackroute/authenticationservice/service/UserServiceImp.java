package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.IUserDao;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImp implements IUserService {

    private IUserDao userDao;
   // private Producer producer;
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserServiceImp(IUserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
//        this.producer = producer;
       // this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByUsername(String emailId) throws UserNotFoundException {
        Optional<User> optional = userDao.findById(emailId);
        if (optional.isEmpty()) {
            throw new UserNotFoundException("usranme is missing");
        }
        return optional.get();
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}