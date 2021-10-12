package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recentBooks")
    public List<BookDTO> recentBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/recent")
    public String getRecentBooks(){
        return "/books/recent";
    }

    @ModelAttribute("popularBooks")
    public List<BookDTO> popularBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/popular")
    public String getPopularBooks(){
        return "/books/popular";
    }
}
