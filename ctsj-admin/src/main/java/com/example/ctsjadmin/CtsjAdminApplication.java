package com.example.ctsjadmin;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableRedisHttpSession
@EnableFeignClients
@SpringBootApplication
//@MapperScan("com.example.ctsjmain.mapper")//添加组件？
public class CtsjAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtsjAdminApplication.class, args);
    }
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
