package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/signin")
    public String signIn(){
        return "/signin";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "/signup";
    }

    @GetMapping("/postponed")
    public String getPostponed(){
        return "/postponed";
    }

    @GetMapping("/cart")
    public String getCart(){
        return "/cart";
    }
}
