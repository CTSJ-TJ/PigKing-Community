package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.Friends;
import com.example.ctsjmain.entity.Posts;
import com.example.ctsjmain.entity.User;
import com.example.ctsjmain.service.PostService;
import com.example.ctsjmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Map show(HttpServletRequest req,
                     @RequestParam("username") String uname,
                     @RequestParam("userpwd") String upwd,
                     @RequestParam("usafe") String usafe
                     ) {
        HttpSession session = req.getSession();
        String vericode = (String) session.getAttribute("verityCode");
        System.out.println("自动生成："+vericode);
        System.out.println("安全码: " + usafe);
        Map<String,Object> map=new HashMap<>();
        if(!vericode.equals(usafe)){
            map.put("code","66");
            return map;
        }else {
            User user = new User();
            user.setUsername(uname);
            user.setUserpwd(upwd);
            System.out.println(userService.login(user).toString());
            User user1=userService.login(user);
            map.put("code","88");
            map.put("data",user1);
            return map;
        }
    }

    @RequestMapping("findfriend")
    @ResponseBody
    public Object FrindFriend(@RequestParam("myid") String myId){
        System.out.println("myid="+myId);
         return userService.findfriend(myId);
    }

    @RequestMapping("setuser")
    @ResponseBody
    public int Setuser(@RequestParam("myname") String myname,@RequestParam("myid") String myid,HttpSession session){
        if(myname!=null&&myid!=null){
            System.out.println("Set:"+myname+", "+myid);
            session.setAttribute("myname", myname);
            session.setAttribute("myid",myid);
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public Map getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String myname = (String) session.getAttribute("myname");
        String myid = (String) session.getAttribute("myid");
        Map<String,Object> map=new HashMap<>();
        map.put("myname",myname);
        map.put("myid",myid);
        return map;
    }
}
