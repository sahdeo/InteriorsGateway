package com.stackroute.orderservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Order API", version = "2.0"))
public class OrderServiceApplication {

	public static void main(String[] args){
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
