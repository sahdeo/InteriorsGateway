package com.stackroute.authenticationservice.rabbitmqConfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.domain.EmailDto;
import rabbitmq.domain.UserDto;

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

    public void sendMessageToRabbitmq(EmailDto emailDto){
        rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, emailDto);
    }
    public void sendMessageToRabbitmqReg(UserDto userDto){
        rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY_REG, userDto);
    }

}
