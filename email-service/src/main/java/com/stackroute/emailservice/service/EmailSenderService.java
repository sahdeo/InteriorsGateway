package com.stackroute.emailservice.service;

import com.stackroute.emailservice.model.EmailRequest;
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



