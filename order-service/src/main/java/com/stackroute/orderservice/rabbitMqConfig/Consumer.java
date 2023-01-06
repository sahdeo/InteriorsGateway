package com.stackroute.orderservice.rabbitMqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;




@Component
public class Consumer {

//    @Autowired
//    private EmailServiceJavaApi emailServiceJavaApi;
    @RabbitListener(queues="design-queue")
    public void getDataFromRabbitmq(DesignDto request) throws Exception{
//        EmailRequest emailRequest= new EmailRequest();
//        emailRequest.setEmailSubject("Here is your OTP!");
//        emailRequest.setToEmail(request.getEmailId());
//        emailRequest.setName(request.getName());
//        emailRequest.setEmailBody(String.valueOf(request.getOtp()));
//        emailServiceJavaApi.sendEmailToCustomers(emailRequest);
    }


}
