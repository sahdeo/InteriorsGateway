package com.stackroute.customerservice.emailservice;

import com.stackroute.customerservice.emailservice.dto.EmailRequest;
import com.stackroute.customerservice.emailservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailServiceApplication {

	@Autowired
	private EmailSenderService senderService;

	private EmailRequest emailRequest;


	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
