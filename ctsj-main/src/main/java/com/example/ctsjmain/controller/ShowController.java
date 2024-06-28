package com.example.ctsjmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("show")
public class ShowController {
    @RequestMapping("passege")
    public String show() {
        return "Showtime.html";
    }
}
