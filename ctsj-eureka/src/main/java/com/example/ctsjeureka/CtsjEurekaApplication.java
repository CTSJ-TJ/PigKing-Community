package com.example.ctsjeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CtsjEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtsjEurekaApplication.class, args);
    }

}
