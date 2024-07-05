package com.example.ctsjmain.entity;

import lombok.Data;

@Data
public class Messages {
    private Integer msgid;
    private String content;
    private Integer senderid;
    private String sendername;
    private Integer receiverid;
    private String receivername;
    private String createtime;
    private Integer status;
}
