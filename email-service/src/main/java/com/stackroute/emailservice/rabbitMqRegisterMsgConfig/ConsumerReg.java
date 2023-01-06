package com.stackroute.emailservice.rabbitMqRegisterMsgConfig;

import com.stackroute.emailservice.controller.EmailController;
import com.stackroute.emailservice.dto.EmailRequest;
import com.stackroute.emailservice.service.EmailSenderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import rabbit.domain.UserDto;

import java.util.HashMap;
import java.util.Map;



@Component
public class ConsumerReg {
    @Autowired
    private EmailSenderService emailSenderService;

    @RabbitListener(queues="register-queue")
    public void getMsgFromRabbitMq(UserDto userDto) throws Exception{

        EmailRequest emailRequest= new EmailRequest();
        emailRequest.setEmailSubject("Welcome to Interiors Gateway");
        emailRequest.setToEmail(userDto.getEmailId());
        emailRequest.setName(userDto.getUserFirstName());
        Map<String, Object> model = new HashMap<>();
        model.put("Name", emailRequest.getName());
        System.out.println(userDto);
        emailSenderService.sendEmail(emailRequest,model);
       // emailController.sendEmail(emailRequest);
    }


}

