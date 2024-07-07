package com.example.ctsjlogin;

import com.example.ctsjlogin.vo.LoginProperties;
import com.example.ctsjlogin.web.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@AutoConfiguration
@ConditionalOnProperty(prefix = "login",name="enable")
@ComponentScan("com.example.ctsjlogin")
public class CtsjLoginApplication implements WebMvcConfigurer {

    @Bean
    @ConditionalOnMissingBean(JdbcTemplate.class)
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Autowired
    LoginProperties properties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
        properties.getAuthUrls().forEach(url->{
            System.out.println("url = " + url);
            registration.addPathPatterns(url);
        });
    }
    @Bean
    public JavaMailSenderImpl JavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setUsername("xxx@qq.com");
        javaMailSender.setPassword("xxxxxx");
        return javaMailSender;
    }

}
