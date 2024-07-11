//package com.example.ctsjmain.controller;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class TestController {
//    @Resource
//    RestTemplate restTemplate;
//
//    @RequestMapping("yyds")
//    @ResponseBody
//    public String handleRequest() {
//        String result=restTemplate.getForObject(
//                "http://ctsj-gateway/yyds",
//                String.class);
//        System.out.println("who:"+result);
//        return  result;
//    }
//
//    @RequestMapping("/wgds")
//    public ModelAndView test1() {
//        // 这里是你的逻辑
//        String targetUrl = "http://127.0.0.1:10006/yyds";
//        return new ModelAndView("redirect:" + targetUrl);
//    }
//
//    @RequestMapping("toadmin")
//    @ResponseBody
//    public String order(@RequestParam("adminid") String adminid, @RequestParam("adminname") String adminname){
//        String ptah1="http://ctsj-admin/identity?adminid="+adminid+"&adminname="+adminname;
//        String result1=restTemplate.getForObject(ptah1, String.class);
//        String result2=restTemplate.getForObject(
//                "http://ctsj-gateway/yyds",
//                String.class);
//        System.out.println("who:"+result2);
//        return  result2;
//    }
//}
