package com.stackroute.authenticationservice.rabbitmqConfig;

import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.service.IUserService;
import com.stackroute.authenticationservice.service.UserServiceImp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rabbitmq.domain.UserDto;

@Component
public class Consumer {
    @Autowired
    private UserServiceImp userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @RabbitListener(queues="register-queue")
    public void getDataFromRabbitmq(UserDto userDto) throws Exception {
        User user = new User();
        user.setEmailId(userDto.getEmailId());
        user.setUserPassword(userDto.getUserPassword());
        //user.setConfirmPassword(userDto.getConfirmPassword());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setMobileNo(userDto.getMobileNo());
        user.setRole(userDto.getRole());
        userService.registerNewUser(user);

    }
    public String getEncodedPassword(String password) {
       return new BCryptPasswordEncoder().encode(password);
        //return passwordEncoder.de(password);
    }
}
