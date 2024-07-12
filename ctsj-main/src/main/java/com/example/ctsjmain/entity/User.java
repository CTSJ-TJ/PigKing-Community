package com.example.ctsjmain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer userid;
    private String username;
    private String userpwd;
    private String usertel;
    private String useremail;
    private String usertime;
    private Integer userstatus;
}
