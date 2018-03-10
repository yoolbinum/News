package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
        return "model/user/account";
    }

    @PostMapping("/account")
    public String account(@Valid @ModelAttribute("user") User newUser, BindingResult result, Model model){
        if(result.hasErrors()){
            return "model/user/account";
        }
        User user = userService.findByUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setBusiness(newUser.isBusiness());
        user.setEntertainment(newUser.isEntertainment());
        user.setGeneral(newUser.isGeneral());
        user.setHealth(newUser.isHealth());
        user.setScience(newUser.isScience());
        user.setSports(newUser.isSports());
        user.setTechnology(newUser.isTechnology());
        userService.saveUser(user);
        return "redirect:/";
    }

}
