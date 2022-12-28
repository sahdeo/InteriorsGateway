<<<<<<< HEAD:email-service/src/main/java/com/stackroute/customerservice/emailservice/controller/EmailController.java
package com.stackroute.customerservice.emailservice.controller;
import java.util.HashMap;
import java.util.Map;

import com.stackroute.customerservice.emailservice.dto.EmailRequest;
import com.stackroute.customerservice.emailservice.dto.EmailResponse;
import com.stackroute.customerservice.emailservice.service.EmailSenderService;
=======
package com.stackroute.emailservice.controller;

import com.stackroute.emailservice.model.EmailRequest;
import com.stackroute.emailservice.service.EmailSenderService;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:email-service/src/main/java/com/stackroute/emailservice/controller/EmailController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD:email-service/src/main/java/com/stackroute/customerservice/emailservice/controller/EmailController.java

=======
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:email-service/src/main/java/com/stackroute/emailservice/controller/EmailController.java
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

