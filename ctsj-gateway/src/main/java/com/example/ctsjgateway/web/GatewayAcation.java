package com.example.ctsjgateway.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("way")
public class GatewayAcation {
    @RequestMapping("hello")
    String Hello(){
        return "Wg: hello welcome!!";
    }
}
