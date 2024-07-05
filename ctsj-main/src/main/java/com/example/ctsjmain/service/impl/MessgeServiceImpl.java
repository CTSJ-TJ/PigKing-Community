package com.example.ctsjmain.service.impl;

import com.example.ctsjmain.entity.Messages;
import com.example.ctsjmain.mapper.MessageMapper;
import com.example.ctsjmain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessgeServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Messages> findinteract(String myid,String otherid){
        return messageMapper.findinteract(myid,otherid);
    }

    @Override
    public int addchat(Messages messages){
         return messageMapper.addchat(messages);
    }
}
