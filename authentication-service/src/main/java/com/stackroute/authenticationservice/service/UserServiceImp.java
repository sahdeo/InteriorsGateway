package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.IUserDao;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.enums.Roles;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.rabbitmqConfig.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rabbitmq.domain.EmailDto;
import rabbitmq.domain.UserDto;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Optional;
import java.util.Random;


@Service
public class UserServiceImp implements IUserService {

    private IUserDao userDao;
    private Producer producer;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImp(IUserDao userDao, Producer producer) {
        this.userDao = userDao;
        this.producer = producer;
    }

    @Override
    public User registerNewUser(User user) {
        UserDto userDto= new UserDto();
        userDto.setEmailId(user.getEmailId());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setUserFirstName(user.getUserFirstName());
        userDto.setUserLastName(user.getUserLastName());
        userDto.setMobileNo(user.getMobileNo());
        userDto.setRole(user.getRole());
        producer.sendMessageToRabbitmqReg(userDto);
        return userDao.save(user);
    }

    @Override
    public User findByUsername(String emailId) throws UserNotFoundException {
        Optional<User> optional = userDao.findById(emailId);
        if (optional.isEmpty()) {
            throw new UserNotFoundException("username is missing");
        }
        return optional.get();
    }

    @Override
    public EmailDto forgotPassword(String emailId) throws UserNotFoundException {
        Random random = new Random();
        int otp = random.nextInt(999999);
        EmailDto emailDto = new EmailDto();
        emailDto.setEmailId(emailId);
        emailDto.setOtp(otp);
        producer.sendMessageToRabbitmq(emailDto);
        return emailDto;
    }

    public PasswordEncoder getEncodedPassword(String password) {
        return new BCryptPasswordEncoder();
    }

}