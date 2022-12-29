package com.stackroute.authenticationservice.rabbitmqConfig;

import com.stackroute.authenticationservice.dto.JwtRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.domain.UserDto;

@Component
public class Producer {
    private RabbitTemplate rabbitTemplate;
    private  MessageConfig messageConfig;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, MessageConfig messageConfig){
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.messageConfig = messageConfig;
    }

    public void sendMessageToRabbitmq(JwtRequest userDto){
        rabbitTemplate.convertAndSend(messageConfig.EXCHANGE, messageConfig.ROUTING_KEY, userDto);
    }

}
