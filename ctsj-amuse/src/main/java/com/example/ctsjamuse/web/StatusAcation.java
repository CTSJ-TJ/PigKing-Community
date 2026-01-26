package com.example.ctsjamuse.web;

import com.example.ctsjamuse.entity.Clickcollect;
import com.example.ctsjamuse.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ctsjamuse.util.DistributedRateLimiter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("status")
public class StatusAcation {

    @Autowired
    IStatusService service;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("findstatus")
    public Map findstatus (@RequestParam("userid") String userid , @RequestParam("postid") String postid){
        Clickcollect entity=new Clickcollect();
        entity.setUserid(Integer.valueOf(userid));
        entity.setPostid(Integer.valueOf(postid));
        Map map=service.findstatus(entity);

        return map;
    }

    @RequestMapping("modify")
    public int handleRequest(@RequestParam("userid") String userid , @RequestParam("postid") String postid,
                                @RequestParam(required = false) String click, @RequestParam(required = false) String collect) {

        DistributedRateLimiter rateLimiter = new DistributedRateLimiter(redisTemplate);
        if (rateLimiter.shouldLimit(userid)) {
            System.out.println("过于频繁操作");
            return -2;  // 返回一个错误码表示请求被限制
        }
        Map map=new HashMap<>();
        Clickcollect entity=new Clickcollect();
       entity.setUserid(Integer.valueOf(userid));
       entity.setPostid(Integer.valueOf(postid));
        if (click!= null) {
            entity.setClickstatus(Integer.valueOf(click));
        } else if (collect != null) {
            entity.setCollectstatus(Integer.valueOf(collect));
        }
        int result=service.modify(entity);
        return result;
    }



}
