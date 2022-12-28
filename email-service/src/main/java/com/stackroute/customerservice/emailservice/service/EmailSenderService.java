package com.stackroute.customerservice.emailservice.service;

<<<<<<< HEAD:email-service/src/main/java/com/stackroute/customerservice/emailservice/service/EmailSenderService.java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.stackroute.customerservice.emailservice.dto.EmailRequest;
import com.stackroute.customerservice.emailservice.dto.EmailResponse;
=======
import com.stackroute.emailservice.model.EmailRequest;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:email-service/src/main/java/com/stackroute/emailservice/service/EmailSenderService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    public String sendEmail(EmailRequest emailRequest) {
        try {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(sender);
            message.setTo(emailRequest.getToEmail());
            message.setText(emailRequest.getEmailBody());
            message.setSubject(emailRequest.getEmailSubject());

            mailSender.send(message);
            return "email sent";

        } catch (Exception e) {
            return "Error while sending mail";
        }
    }

}
