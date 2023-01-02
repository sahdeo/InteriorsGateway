//package com.stackroute.emailservice.rabbitMqRegisterMsgConfig;
//
//import com.stackroute.emailservice.rabbitMqConfig.MessageConfig;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MessageConfigReg {
//    private MessageConfig messageConfig;
//
//   // public static final String QUEUEREG="register-queue";
//    //public static final String EXCHANGE_REG="register-exchange";
////    public static final String ROUTING_KEY_REG="register-routing";
////    @Bean
////    public Queue queueReg(){
////        return new Queue(QUEUEREG,false);
////    }
//
//
//    public DirectExchange directExchangeReg(){
//        //return new DirectExchange(EXCHANGE);
//       return messageConfig.directExchange();
//    }
////    @Bean
////    public Binding userBindingReg(Queue queue, DirectExchange exchange){
////        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_REG);
////    }
//    @Bean
//    public Jackson2JsonMessageConverter messageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
//    /**
//     * AmqpTemplate: used to publish and consume the event from service
//     */
////    @Bean
////    public AmqpTemplate template(ConnectionFactory connectionFactory){
////        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
////        rabbitTemplate.setMessageConverter(messageConverter());
////        return rabbitTemplate;
////    }
//
//}
