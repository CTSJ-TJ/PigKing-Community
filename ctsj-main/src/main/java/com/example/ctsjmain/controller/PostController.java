package com.example.ctsjmain.controller;


import com.example.ctsjmain.entity.Posts;
import com.example.ctsjmain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/post")
public class PostController{

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "wg", method = RequestMethod.GET)
    public String hello(Posts posts) {
        System.out.println("Name = " + posts.getPosttile());
        return "Parameters received and printed!";
    }

    @Autowired
    PostService postService;
    @RequestMapping("findall")
    @ResponseBody
    public Object findall(@RequestParam("status") String status){
        return postService.findall(status);
    }

    @RequestMapping("findlike")
    @ResponseBody
    public Object findlike(@RequestParam("status") String status,@RequestParam("like") String likestring){
        return postService.findlike(status,likestring);
    }

    @RequestMapping("findId")
    @ResponseBody
    public Object getPost(@RequestParam("postid") String postId){
        System.out.println("the postid:"+postId);
        System.out.println("who:"+postService.findId(postId).toString());
        return postService.findId(postId);
    }



    @RequestMapping(value = "addpost", method = RequestMethod.POST)
    @ResponseBody
    public int AddPost(@RequestBody Posts posts){
        System.out.println("the add:"+posts.toString());
        int result = postService.addpost(posts);
        System.out.println("who add:"+ result);
        return result;
    }



    @RequestMapping("gateway")
    public String user(){
        return  restTemplate.getForObject(
                "http://ctsj-gateway/",
                String.class);
    }

    @RequestMapping("show")
    String show(){
        return "Showtime.html";
    }

}
