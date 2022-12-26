package com.stackroute.authenticationservice.rabbitmqConfig;

import com.stackroute.authenticationservice.dto.JwtRequest;
import com.stackroute.authenticationservice.entity.User;
import rabbitmq.domain.UserDto;

public class consumer {

    public void getDataFromRabbitmq(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setUserPassword(userDto.getUserPassword());
        user.setRole(userDto.getRole());
    }
}
