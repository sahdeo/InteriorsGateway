package com.stackroute.orderservice.rabbitMqConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String QUEUE_DES="design-queue";
    public static final String EXCHANGE="design-exchange";
    public static final String ROUTING_KEY_DES="register-routing";

    @Bean
    public  Queue queue(){
        return new Queue(QUEUE_DES,false);
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
                .with(ROUTING_KEY_DES);
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
