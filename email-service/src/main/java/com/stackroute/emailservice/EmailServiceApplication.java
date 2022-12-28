package com.stackroute.emailservice;

import com.stackroute.emailservice.model.EmailRequest;
import com.stackroute.emailservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class EmailServiceApplication {

	@Autowired
	private EmailSenderService senderService;

	private EmailRequest emailRequest;


	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
