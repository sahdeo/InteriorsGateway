package com.stackroute.authenticationservice.rabbitmqConfig;

import com.stackroute.authenticationservice.dto.JwtRequest;
import com.stackroute.authenticationservice.entity.User;
import com.stackroute.authenticationservice.service.IUserService;
import com.stackroute.authenticationservice.service.UserServiceImp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.domain.UserDto;

@Component
public class consumer {
    @Autowired
    private IUserService userService;
    @RabbitListener(queues = "user_queue")
    public void getDataFromRabbitmq(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setUserPassword(userDto.getUserPassword());
        user.setRole(userDto.getRole());
        userService.registerNewUser(user);
    }
}
