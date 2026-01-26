package com.example.ctsjmain.controller;


import com.example.ctsjmain.entity.User;
import com.example.ctsjmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, User> redisTemplate;

    @GetMapping("login")
    public Mono<ResponseEntity<Map<String, Object>>> show(ServerWebExchange exchange) {
        return exchange.getSession().flatMap(session -> {
            Object attribute = session.getAttribute("verityCode");
            if (attribute instanceof String) {
                String vericode = (String) attribute;
                String uname = exchange.getRequest().getQueryParams().getFirst("username");
                String upwd = exchange.getRequest().getQueryParams().getFirst("userpwd");
                String usafe = exchange.getRequest().getQueryParams().getFirst("usafe");
                System.out.println("自动生成：" + vericode);
                System.out.println("安全码: " + usafe);
                Map<String, Object> map = new HashMap<>();
                if (!vericode.equals(usafe)) {
                    map.put("code", "66");
                    return Mono.just(ResponseEntity.ok(map));
                } else {
                    User user = new User();
                    user.setUsername(uname);
                    user.setUserpwd(upwd);
                    User user1=userService.login(user);
                    if(user1 == null){
                        map.put("code", 77);
                        return Mono.just(ResponseEntity.ok(map));
                    }
                    map.put("code","88");
                    map.put("data",user1);
                    return Mono.just(ResponseEntity.ok(map));
                }
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", "66");
                map.put("message", "verityCode is not a string");
                return Mono.just(ResponseEntity.ok(map));
            }
        });
    }


    @RequestMapping("setuser")
    @ResponseBody
    public int Setuser(@RequestParam("myname") String myname,@RequestParam("myid") String myid){
        if(myname!=null&&myid!=null){
              User user=new User();
              user.setUsername(myname);
              user.setUserid(Integer.valueOf(myid));
              redisTemplate.opsForValue().set("user:"+myid, user);
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public Map getSession(@RequestParam("myid") String myid) {
        User user = redisTemplate.opsForValue().get("user:"+myid);
        if(user!=null) {
            String myname = user.getUsername();
            Map<String, Object> map = new HashMap<>();
            map.put("myname", myname);
            map.put("myid", myid);
            return map;
        }else {
            System.out.println("user: this is null");
            return null;
        }
    }


    @GetMapping("adduser")
    public Mono<ResponseEntity<Map<String, Object>>> AddUser(ServerWebExchange exchange) {
        return exchange.getSession().flatMap(session -> {
            Object attribute = session.getAttribute("verityCode");
            if (attribute instanceof String) {
                String vericode = (String) attribute;
                String uname = exchange.getRequest().getQueryParams().getFirst("username");
                String upwd = exchange.getRequest().getQueryParams().getFirst("userpwd");
                String usafe = exchange.getRequest().getQueryParams().getFirst("usafe");
                System.out.println("自动生成1：" + vericode);
                System.out.println("安全码1: " + usafe);
                Map<String, Object> map = new HashMap<>();
                if (!vericode.equals(usafe)) {
                    map.put("code", "66");
                    return Mono.just(ResponseEntity.ok(map));
                } else {
                    User user = new User();
                    user.setUsername(uname);
                    user.setUserpwd(upwd);
                    int result= userService.add(user);
                    if(result<=0){
                        map.put("code", 77);
                        return Mono.just(ResponseEntity.ok(map));
                    }
                    map.put("code","88");
                    map.put("data",result);
                    return Mono.just(ResponseEntity.ok(map));
                }
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", "66");
                map.put("message", "verityCode is not a string");
                return Mono.just(ResponseEntity.ok(map));
            }
        });
    }

    @RequestMapping("find")
    @ResponseBody
    public List<User> find(@RequestParam("values") String values){
         return userService.find(values);
    }

}
