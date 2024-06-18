package com.example.ctsjindex.controller;

import com.example.ctsjindex.entity.Posts;
import com.example.ctsjindex.mapper.PostMapper;
import com.example.ctsjindex.service.PostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return postService.findall();
    }

//    @RequestMapping("all")
//    public List<Posts> findall(){
//
//    }

}
