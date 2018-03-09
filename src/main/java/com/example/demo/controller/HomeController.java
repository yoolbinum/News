package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "homepage";
    }

    @RequestMapping("/account")
    public String account(Authentication auth){
        return "model/user/account";
    }

}
