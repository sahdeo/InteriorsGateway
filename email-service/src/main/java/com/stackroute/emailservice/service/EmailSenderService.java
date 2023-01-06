package com.stackroute.emailservice.service;

import com.stackroute.emailservice.dto.EmailRequest;
import com.stackroute.emailservice.dto.EmailResponse;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;

    public EmailResponse sendEmail(EmailRequest request, Map<String, Object> model) {
        EmailResponse response = new EmailResponse();
        MimeMessage message = sender.createMimeMessage();
        try {
            // set mediaType
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            // add attachment
            helper.addAttachment("logo.png", new ClassPathResource("logo.png"));


            Template t = config.getTemplate("email-template.ftl");

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);


            helper.setTo(request.getToEmail());
            helper.setText(html,true);
            helper.setSubject(request.getEmailSubject());
            helper.setFrom("interiorsgateway3@gmail.com");
            sender.send(message);

            response.setMessage("mail send to : " + request.getToEmail());
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException | IOException | TemplateException e) {
            response.setMessage("Mail Sending failure : "+e.getMessage());
            response.setStatus(Boolean.FALSE);
        }
        System.out.println("email sent");
        return response;
    }
}

