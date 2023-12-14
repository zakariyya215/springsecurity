package com.zakariyya.security01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {
    @GetMapping("toLogin")
    public String toLogin(){
        System.out.println("跳转到登录页面");
        return "login";
    }
}
