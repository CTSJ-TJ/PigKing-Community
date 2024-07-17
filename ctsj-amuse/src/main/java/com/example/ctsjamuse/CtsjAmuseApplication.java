package com.example.ctsjamuse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.example.ctsjamuse.mapper")//添加组件？
public class CtsjAmuseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtsjAmuseApplication.class, args);
    }

}
