package com.example.ctsjmain.entity;

import lombok.Data;

@Data
public class User {
    private Integer userid;
    private String username;
    private String userpwd;
    private String usertel;
    private String useremail;
    private String usertime;
    private Integer userstatus;
}
