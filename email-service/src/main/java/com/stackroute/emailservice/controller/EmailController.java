package com.stackroute.emailservice.controller;

import com.stackroute.emailservice.model.EmailRequest;
import com.stackroute.emailservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/IG")
public class EmailController {
    @Autowired
    private EmailSenderService senderService;


    @PostMapping("/sentEmail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        String status = senderService.sendEmail(emailRequest);
        return status;
    }
}
