package com.stackroute.emailservice.service;

import com.stackroute.emailservice.dto.EmailRequest;
import com.stackroute.emailservice.dto.EmailResponse;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceJavaApi {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;
    public EmailResponse sendEmailToCustomers(EmailRequest request) {
        EmailResponse response = new EmailResponse();
        MimeMessage message = sender.createMimeMessage();
        try {
            // set mediaType
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            // add attachment
            helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

            helper.setSubject(request.getEmailSubject());
            helper.setTo(request.getToEmail());
            helper.setText("OTP: "+ request.getEmailBody());

            helper.setFrom("interiorsatgateway@gmail.com");
            sender.send(message);

            response.setMessage("mail send to : " + request.getToEmail());
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException e) {
            response.setMessage("Mail Sending failure : "+e.getMessage());
            response.setStatus(Boolean.FALSE);
        }
        System.out.println("email sent");
        return response;
    }
}
