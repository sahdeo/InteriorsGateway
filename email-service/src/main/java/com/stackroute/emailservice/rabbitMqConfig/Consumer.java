package com.stackroute.emailservice.rabbitMqConfig;

import com.stackroute.emailservice.dto.EmailRequest;
import com.stackroute.emailservice.service.EmailServiceJavaApi;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbit.domain.EmailDto;




@Component
public class Consumer {
    //    @Autowired
//    private EmailController emailController;
    @Autowired
    private EmailServiceJavaApi emailServiceJavaApi;
    @RabbitListener(queues="forget-queue")
    public void getDataFromRabbitmq(EmailDto request) throws Exception{
        EmailRequest emailRequest= new EmailRequest();
        emailRequest.setEmailSubject("Here is your OTP!");
        emailRequest.setToEmail(request.getEmailId());
        emailRequest.setName(request.getName());
        emailRequest.setEmailBody(String.valueOf(request.getOtp()));
        emailServiceJavaApi.sendEmailToCustomers(emailRequest);
    }


}
