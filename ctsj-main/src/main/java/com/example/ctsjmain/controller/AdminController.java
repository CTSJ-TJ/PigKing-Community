package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.Admin;
import com.example.ctsjmain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Resource
    RestTemplate restTemplate;

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
//            System.out.println(adminService.login(admin).toString());
            Admin admin1=adminService.login(admin);
            if (admin1==null){
                map.put("code",77);
                return map;
            }
            map.put("code","88");
            map.put("data",admin1);
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
//            return restTemplate.postForObject("http://ctsj-admin/admin", entity, String.class);
            return map;
        }
    }

    @RequestMapping("toadmin")
    @ResponseBody
    public String order(@RequestParam("adminid") String adminid, @RequestParam("adminname") String adminname){
        String ptah1="http://ctsj-admin/identity?adminid="+adminid+"&adminname="+adminname;
        String result1=restTemplate.getForObject(ptah1, String.class);
        String result2=restTemplate.getForObject(
                "http://ctsj-gateway/yyds",
                String.class);
        System.out.println("who:"+result2);
        return  result2;
    }

}
