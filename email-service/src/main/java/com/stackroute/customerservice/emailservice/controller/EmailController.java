package com.stackroute.customerservice.emailservice.controller;
import java.util.HashMap;
import java.util.Map;

import com.stackroute.customerservice.emailservice.dto.EmailRequest;
import com.stackroute.customerservice.emailservice.dto.EmailResponse;
import com.stackroute.customerservice.emailservice.service.EmailSenderService;
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

    @PostMapping("/sendingEmail")
    public EmailResponse sendEmail(@RequestBody EmailRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());

        return senderService.sendEmail(request, model);

    }

}



