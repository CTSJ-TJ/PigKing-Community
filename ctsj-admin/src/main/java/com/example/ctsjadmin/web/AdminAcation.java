package com.example.ctsjadmin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminAcation {

    @RequestMapping("identity")
    @ResponseBody
    public String mytest(HttpSession session,@RequestParam("adminid") String adminid, @RequestParam("adminname") String adminname){
        if(adminid!=null&&adminname!=null){
            System.out.println("Set:"+adminid+", "+adminname);
            session.setAttribute("adminname", adminname);
            session.setAttribute("adminid",adminid);
            return "yes";
        }else {
            return "no";
        }
    }

    @RequestMapping("/getadmin")
    @ResponseBody
    public Map getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String myname = (String) session.getAttribute("adminname");
        String myid = (String) session.getAttribute("adminid");
        Map<String,Object> map=new HashMap<>();
        map.put("myname",myname);
        map.put("myid",myid);
        return map;
    }


    @RequestMapping("yyds")
    @ResponseBody
    public String mytest(HttpServletRequest request){
//        System.out.println("hello!!");
//        return new ModelAndView("redirect:manager/main.html" );
        int port=request.getServerPort();
        String path="http://127.0.0.1:"+port+"/manager/main.html";
//        System.out.println("the path:"+path);
        return path;
    }






    // 处理请求
//    @RequestMapping(value = "/admin", method = RequestMethod.POST)
//    public String myname(@RequestBody Map<String, Object> map, HttpServletRequest request){
//        int port=request.getServerPort();
//        // 使用map中的数据
//        System.out.println("admin:"+map.get("data"));
//        System.out.println("this is order:"+port);
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("manager/main");
//        String path="127.0.0.1:"+port+"/manager/main.html";
//        System.out.println("path:"+path);
//        return path;
//    }



}
