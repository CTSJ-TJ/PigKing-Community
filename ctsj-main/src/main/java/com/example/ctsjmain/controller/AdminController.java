package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.Admin;
import com.example.ctsjmain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public Map show(HttpServletRequest req,
                    @RequestParam("adminname") String adminname,
                    @RequestParam("adminpwd") String adminpwd,
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
            Admin admin=new Admin();
            admin.setAdminname(adminname);
            admin.setAdminpwd(adminpwd);
            System.out.println(adminService.login(admin).toString());
            Admin admin1=adminService.login(admin);
            map.put("code","88");
            map.put("data",admin1);
            return map;
        }
    }
}
