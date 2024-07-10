package com.example.ctsjadmin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("post")
public class PostAcation {
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("findall")
    public Object findall(){
        return restTemplate.getForObject(
                "http://ctsj-main/post/findall",
                String.class);
    }

    @RequestMapping("findId")
    public Object findid(@RequestParam("postid") String postId){
        return restTemplate.getForObject(
                "http://ctsj-main/post/findId?postid="+postId,
                String.class);
    }

}
