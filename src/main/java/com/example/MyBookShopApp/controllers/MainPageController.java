package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<BookDTO> recommendedBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String mainPage(){
        return "/index";
    }

    @GetMapping("/documents")
    public String getDocuments(){
        return "/documents/index";
    }

    @GetMapping("/documents/SLUG")
    public String getDocumentsSlug(){
        return "/documents/slug";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "/about";
    }

    @GetMapping("/faq")
    public String getFAQ(){
        return "/faq";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "/contacts";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "query") String query, Model model){
        model.addAttribute("filteredBookList", bookService.getBooksData());
        return "/search/index";
    }
}
