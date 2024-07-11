package com.example.ctsjmain.controller;

import com.example.ctsjmain.entity.Admin;
import com.example.ctsjmain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final WebClient webClient;
    @Autowired
    public AdminController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    @Autowired
    AdminService adminService;

    @GetMapping("login")
    public Mono<ResponseEntity<Map<String, Object>>> show(ServerWebExchange exchange) {
        return exchange.getSession().flatMap(session -> {
            Object attribute = session.getAttribute("verityCode");
            if (attribute instanceof String) {
                String vericode = (String) attribute;
                String adminname = exchange.getRequest().getQueryParams().getFirst("adminname");
                String adminpwd = exchange.getRequest().getQueryParams().getFirst("adminpwd");
                String usafe = exchange.getRequest().getQueryParams().getFirst("usafe");
                System.out.println("自动生成：" + vericode);
                System.out.println("安全码: " + usafe);
                Map<String, Object> map = new HashMap<>();
                if (!vericode.equals(usafe)) {
                    map.put("code", "66");
                    return Mono.just(ResponseEntity.ok(map));
                } else {
                    Admin admin = new Admin();
                    admin.setAdminname(adminname);
                    admin.setAdminpwd(adminpwd);
                    Admin admin1 = adminService.login(admin);
                    if (admin1 == null) {
                        map.put("code", 77);
                        return Mono.just(ResponseEntity.ok(map));
                    }
                    map.put("code", "88");
                    map.put("data", admin1);
                    return Mono.just(ResponseEntity.ok(map));
                }
            } else {
                // Handle the case where attribute is not a String
                Map<String, Object> map = new HashMap<>();
                map.put("code", "99");
                map.put("message", "verityCode is not a string");
                return Mono.just(ResponseEntity.ok(map));
            }
        });
    }

    @GetMapping("toadmin")
    public Mono<String> order(@RequestParam("adminid") String adminid, @RequestParam("adminname") String adminname){
        String path1 = "http://ctsj-admin/identity?adminid=" + adminid + "&adminname=" + adminname;
        return webClient.get()
                .uri(path1)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(result1 -> {
                    System.out.println("the:"+result1);
                    if ("yes".equals(result1)) {
                        return webClient.get()
                                .uri("http://ctsj-gateway/yyds")
                                .retrieve()
                                .bodyToMono(String.class);
                    } else {
                        return Mono.just("Access Denied");
                    }
                });
    }

//    @RequestMapping("toadmin")
//    @ResponseBody
//    public String order(@RequestParam("adminid") String adminid, @RequestParam("adminname") String adminname){
//        String ptah1="http://ctsj-admin/identity?adminid="+adminid+"&adminname="+adminname;
//        String result1=restTemplate.getForObject(ptah1, String.class);
//        System.out.println("reul1:"+result1);
//        String result2=restTemplate.getForObject(
//                "http://ctsj-gateway/yyds",
//                String.class);
//        System.out.println("who:"+result2);
//        return  result2;
//    }
}
