package com.example.ctsjmain.service;

import com.example.ctsjmain.entity.Messages;

import java.util.List;

public interface MessageService {
    List<Messages> findinteract(String myid,String otherid);
    int addchat(Messages messages);
}
