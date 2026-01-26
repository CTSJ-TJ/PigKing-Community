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

    @RequestMapping("finduser")
    @ResponseBody
    public Object finduser(@RequestParam("userid") String userid){
         return postService.finduser(userid);
    }

    @RequestMapping("findId")
    @ResponseBody
    public Object getPost(@RequestParam("postid") String postId){
        System.out.println("the postid:"+postId);
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

    @RequestMapping("modify")
    @ResponseBody
    public int modify(@RequestParam("postid") String postId,
                         @RequestParam(required = false) String click, @RequestParam(required = false) String collect){
        Posts posts=new Posts();
        posts.setPostid(Integer.valueOf(postId));
        if(click!=null){
           posts.setPostlikes(Integer.valueOf(click));
        }else if(collect!=null){
            posts.setCollections(Integer.valueOf(collect));
        }
        System.out.println("the postid:"+postId);
        int a=postService.modify(posts);
        System.out.println("hte a:"+a);
        return a;
    }

    @RequestMapping("modstus")
    @ResponseBody
    public int modstus(@RequestParam("postid") String postId,@RequestParam("status") String value){
        Posts posts=new Posts();
        posts.setPostid(Integer.valueOf(postId));
        posts.setStatus(Integer.valueOf(value));
       return postService.modstatus(posts);
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
