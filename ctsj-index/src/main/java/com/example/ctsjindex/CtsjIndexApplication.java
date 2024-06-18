package com.example.ctsjindex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ctsjindex.mapper")//添加组件？
public class CtsjIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtsjIndexApplication.class, args);
    }

}
