package com.stackroute.userservice.rabbitmqConfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String QUEUE_REG="register-queue";
    public static final String EXCHANGE="user-exchange";
    public static final String ROUTING_KEY_REG="register-routing";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE_REG,false);
    }
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE);
    }
    @Bean
    public Binding userBinding(Queue queue, DirectExchange exchange){
        return BindingBuilder
                .bind(queue())
                .to(exchange)
                .with(ROUTING_KEY_REG);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    /**
     * AmqpTemplate: used to publish and consume the event from service
     */
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
