package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
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
    public String search(@RequestParam(value = "query", required = false) String query, Model model){
        System.out.println(query);
        if (query!=null && !query.isEmpty()){
            List<Book> books = bookService.getFilteredBooksData(query);
            int count = books.size();
            model.addAttribute("filteredBookList", books);
            model.addAttribute("count", count);
            if(count==1){
                model.addAttribute("countMessage", "Найдена 1 книга");
            }else if((count>5 & count<21) || count%10==0 || Arrays.asList("5", "6", "7", "8", "9").contains(String.valueOf(count).substring(String.valueOf(count).length()-1))){
                model.addAttribute("countMessage", "Найдено " + count + " книг");
            }else if (String.valueOf(count).substring(String.valueOf(count).length()-1).equals("1")){
                model.addAttribute("countMessage", "Найдено " + count + " книга");
            }else if ((count>1 & count<5) || Arrays.asList("2", "3", "4").contains(String.valueOf(count).substring(String.valueOf(count).length()-1))){
                model.addAttribute("countMessage", "Найдено " + count + " книги");
            }
        } else {
            model.addAttribute("searchError", "Поисковый запрос не задан");
            return "/index";
        }
        return "/search/index";
    }
}
