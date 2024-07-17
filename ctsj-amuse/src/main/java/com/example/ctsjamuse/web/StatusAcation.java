package com.example.ctsjamuse.web;

import com.example.ctsjamuse.entity.Clickcollect;
import com.example.ctsjamuse.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("status")
public class StatusAcation {

    @Autowired
    IStatusService service;


    @RequestMapping("findstatus")
    public Map findstatus (@RequestParam("userid") String userid , @RequestParam("postid") String postid){
        Clickcollect entity=new Clickcollect();
        entity.setUserid(Integer.valueOf(userid));
        entity.setPostid(Integer.valueOf(postid));
        Map map=service.findstatus(entity);
        return map;
    }


}
