package com.example.ctsjlogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.ctsjlogin.mapper")
@SpringBootApplication
public class CtsjLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtsjLoginApplication.class, args);
    }
}
