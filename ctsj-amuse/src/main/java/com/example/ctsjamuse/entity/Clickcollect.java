package com.example.ctsjamuse.entity;

import lombok.Data;

@Data
public class Clickcollect {
    private Integer saveid;
    private Integer userid;
    private Integer postid;
    private Integer clickstatus;
    private Integer collectstatus;
    private String clicktime;
    private String collecttime;
}
