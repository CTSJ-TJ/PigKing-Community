package com.example.ctsjmain.mapper;

import com.example.ctsjmain.entity.Messages;

import java.util.List;

public interface MessageMapper {
    List<Messages> findinteract(String myid,String otherid);
    int addchat(Messages messages);
}
