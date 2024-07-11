package com.example.ctsjadmin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private Integer adminid;
    private String adminname;
    private String adminpwd;
    private String admintel;
    private String adminemail;
    private Integer adminstatus;
}
