package com.example.ctsjgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class CtsjGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtsjGatewayApplication.class, args);
	}

}
