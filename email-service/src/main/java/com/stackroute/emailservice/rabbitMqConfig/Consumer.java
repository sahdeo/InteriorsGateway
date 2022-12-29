package com.stackroute.emailservice.rabbitMqConfig;

import com.stackroute.emailservice.controller.EmailController;
import com.stackroute.emailservice.dto.EmailRequest;
import com.stackroute.emailservice.service.EmailSenderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbit.domain.UserDto;

import java.util.HashMap;
import java.util.Map;

@Component
public class Consumer {
    @Autowired
    private EmailController emailController;
    @RabbitListener(queues="user-queue")
    public void getDataFromRabbitmq(UserDto request) throws Exception{
        EmailRequest emailRequest= new EmailRequest();
        emailRequest.setEmailFrom(request.getEmailId());
        emailRequest.setEmailSubject("Welcome to Interiors Gateway");
        emailRequest.setEmailFrom("interiors.gateway@gmail.com");
        emailRequest.setName(request.getName());
//        Map<String, Object> modeMap = new HashMap<>();
//        modeMap.put("Name", request.getName());
        emailController.sendEmail(emailRequest);
    }


}
