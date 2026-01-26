package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.Messages;
import com.example.ctsjmain.service.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("message")
public class ExchangeController {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    MessageService messageService;
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("chat")
    @ResponseBody
    public List<Messages> findinteract(@RequestParam("myid") String myid, @RequestParam("otherid") String otherid){
        return messageService.findinteract(myid,otherid);
    }

    @RequestMapping("addchat")
    @SendTo("/topic/messages")
    @ResponseBody
    public int addchat(Messages messages){
        int result = messageService.addchat(messages);
        this.template.convertAndSend("/topic/messages", messages);
        return result;
    }

//    @RabbitListener(queues = "/topic/messages")
//    public void receiveMessage(String message) {
//        System.out.println("Received message: " + message);
//    }

}
