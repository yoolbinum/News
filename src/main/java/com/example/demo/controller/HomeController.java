package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home() {
        return "homepage";
    }

    @RequestMapping("/account")
    public String account(Authentication auth, Model model){
        User user = userService.findByUsername(auth.getName());
        model.addAttribute("user", user);
        model.addAttribute("categories", user.getCategories());
        return "model/user/account";
    }

}
