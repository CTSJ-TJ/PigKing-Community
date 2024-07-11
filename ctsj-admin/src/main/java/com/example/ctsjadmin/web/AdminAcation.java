package com.example.ctsjadmin.web;

import com.example.ctsjadmin.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminAcation {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Admin> redisTemplate;

    @RequestMapping("identity")
    @ResponseBody
    public String mytest(@RequestParam("adminid") String adminid, @RequestParam("adminname") String adminname){
        if(adminid!=null&&adminname!=null){
            Admin admin = new Admin();
            admin.setAdminid(Integer.parseInt(adminid));
            admin.setAdminname(adminname);
            redisTemplate.opsForValue().set("admin", admin);
            System.out.println("admin: welcome my wg!!");
            return "yes";
        }else {
            return "no";
        }
    }

    @RequestMapping("/getadmin")
    @ResponseBody
    public Map getSession() {
        Admin admin = redisTemplate.opsForValue().get("admin");
        if (admin != null) {
            String myid = String.valueOf(admin.getAdminid());
            String myname = admin.getAdminname();
            Map<String,Object> map=new HashMap<>();
            System.out.println("map:"+myname+","+myid);
            map.put("myname",myname);
            map.put("myid",myid);
            return map;
        } else {
            System.out.println("admin: this is");
            return null;
        }
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
