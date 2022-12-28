package com.stackroute.customerservice.emailservice;

<<<<<<< HEAD:email-service/src/main/java/com/stackroute/customerservice/emailservice/EmailServiceApplication.java
import com.stackroute.customerservice.emailservice.dto.EmailRequest;
import com.stackroute.customerservice.emailservice.service.EmailSenderService;
=======
import com.stackroute.emailservice.model.EmailRequest;
import com.stackroute.emailservice.service.EmailSenderService;
>>>>>>> ac9f2dd2c45337eb2d8b4d107e42b6709308af41:email-service/src/main/java/com/stackroute/emailservice/EmailServiceApplication.java
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
