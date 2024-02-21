package com.ra.controller;

import com.ra.model.entity.Book;
import com.ra.sevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/book")
    public String index(Model model){
       List<Book> books =  bookService.getAll();
       model.addAttribute("books",books);
       return "book/index";
    }
}
