package com.stackroute.emailservice.controller;

import com.stackroute.emailservice.dto.EmailRequest;
import com.stackroute.emailservice.dto.EmailResponse;
import com.stackroute.emailservice.service.EmailSenderService;
import com.stackroute.emailservice.service.EmailServiceJavaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/IG")
public class EmailController {
        @Autowired
        private EmailSenderService senderService;
        @Autowired
        private EmailServiceJavaApi serviceJavaApi;

    @PostMapping("/sendingEmail")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());

        EmailResponse response = senderService.sendEmail(request,model);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}



