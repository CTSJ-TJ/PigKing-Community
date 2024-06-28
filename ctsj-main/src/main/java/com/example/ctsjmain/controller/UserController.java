package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.User;
import com.example.ctsjmain.service.PostService;
import com.example.ctsjmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
            map.put("code","88");
            map.put("data",user);
            return map;
        }
    }
}
