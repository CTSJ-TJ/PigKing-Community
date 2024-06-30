package com.example.ctsjmain.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer adminid;
    private String adminname;
    private String adminpwd;
    private String admintel;
    private String adminemail;
    private Integer adminstatus;
}
