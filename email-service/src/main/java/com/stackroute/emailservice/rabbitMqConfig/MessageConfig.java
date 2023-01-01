package com.stackroute.emailservice.rabbitMqConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String QUEUE="forget-queue";
    public static final String QUEUE_REG="register-queue";

    public static final String ROUTING_KEY="user-routing";
    public static final String ROUTING_KEY_REG="register-routing";

    public static final String EXCHANGE="user-exchange";


    @Bean
    public Queue queue(){
        return new Queue(QUEUE,false);
    }
    @Bean
    public Queue queueReg(){
        return new Queue(QUEUE_REG,false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }


    @Bean
    public Binding userBinding(Queue queue, DirectExchange exchange){
        return BindingBuilder.
                bind(queue())
                .to(exchange)
                .with(ROUTING_KEY);
    }
    @Bean
    public Binding userBindingReg(Queue queue, DirectExchange exchange){
        return BindingBuilder
                .bind(queueReg())
                .to(exchange)
                .with(ROUTING_KEY_REG);
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
