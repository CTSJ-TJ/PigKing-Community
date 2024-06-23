package com.example.ctsjmain.controller;


import com.example.ctsjmain.entity.Posts;
import com.example.ctsjmain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController{

    @RequestMapping(value = "wg", method = RequestMethod.GET)
    public String hello(Posts posts) {
        System.out.println("Name = " + posts.getPosttile());
        return "Parameters received and printed!";
    }

    @Autowired
    PostService postService;
    @RequestMapping("findall")
    @ResponseBody
    public Object getUsers(){
        System.out.println("执行！！");
        System.out.println(postService.findall().toString());
        return postService.findall();
    }

//    @RequestMapping("all")
//    public List<Posts> findall(){
//
//    }

}
