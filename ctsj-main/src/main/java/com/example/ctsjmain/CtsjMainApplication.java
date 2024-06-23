package com.example.ctsjmain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@MapperScan("com.example.ctsjmain.mapper")//添加组件？
public class CtsjMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtsjMainApplication.class, args);
    }

}
