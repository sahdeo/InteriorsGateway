package com.stackroute.apigateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Api-Gateway", version = "2.0"))
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run (ApiGatewayApplication.class, args);
    }

}
