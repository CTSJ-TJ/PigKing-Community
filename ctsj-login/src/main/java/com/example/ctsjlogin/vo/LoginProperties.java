package com.example.ctsjlogin.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "login")
@Data
public class LoginProperties {

    private String userTable;
    private String nameColumn;
    private String pwdColumn;
    private String emailColumn;
    private String entityClass;
    private List<String> authUrls;
    private String sendEmail;

}