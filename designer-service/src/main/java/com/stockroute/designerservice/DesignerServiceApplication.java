package com.stockroute.designerservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Designer API", version = "2.0"))
public class DesignerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignerServiceApplication.class, args);
	}

}
