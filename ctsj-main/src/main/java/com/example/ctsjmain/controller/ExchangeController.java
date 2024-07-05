package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.Messages;
import com.example.ctsjmain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("message")
public class ExchangeController {
    @Autowired
    MessageService messageService;

    @RequestMapping("chat")
    @ResponseBody
    public List<Messages> findinteract(@RequestParam("myid") String myid, @RequestParam("otherid") String otherid){
        System.out.println("myid="+myid+",otherid="+otherid);
        System.out.println("msg:"+messageService.findinteract(myid,otherid).toString());
        return messageService.findinteract(myid,otherid);
    }
    @RequestMapping("addchat")
    @ResponseBody
    public int addchat(Messages messages){
        // 在这里，你可以使用实体类的getter方法来获取请求参数
        System.out.println(messages.getContent());
        System.out.println(messages.getSenderid());
        System.out.println(messages.getSendername());
        System.out.println(messages.getReceiverid());

        return messageService.addchat(messages);
    }


}
