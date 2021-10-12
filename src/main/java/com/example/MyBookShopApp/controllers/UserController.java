package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final BookService bookService;

    @Autowired
    public UserController(BookService bookService) {
        this.bookService = bookService;
    }

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
