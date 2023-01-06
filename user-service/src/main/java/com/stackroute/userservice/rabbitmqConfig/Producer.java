package com.stackroute.userservice.rabbitmqConfig;

import domain.UserDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private RabbitTemplate rabbitTemplate;
    private MessageConfig messageConfig;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, MessageConfig messageConfig){
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.messageConfig = messageConfig;
    }

    public void sendMessageToRabbitmq(UserDto userDto){
        rabbitTemplate.convertAndSend(messageConfig.EXCHANGE, messageConfig.ROUTING_KEY_REG, userDto);
    }

}
