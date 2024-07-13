package com.example.ctsjmyai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CtsjMyaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtsjMyaiApplication.class, args);
    }

}
