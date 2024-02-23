package com.ra.controller;

import com.ra.model.entity.Book;
import com.ra.sevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/add-books")
    public String add(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "book/add";
    }
    @PostMapping("/add-books")
    public String save(@ModelAttribute("book") Book book)
    {
        if(bookService.create(book)){
            return "redirect:/book";
        }
         return "book/add";
    }
    @GetMapping("/delete-book/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);
        return "redirect:/book";
    }

    @GetMapping("/eidt-book/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "book/edit";
    }
    @PostMapping("/eidt-book/{id}")
    public String update(@PathVariable("id") int id,@ModelAttribute("book") Book book){
        if(bookService.update(book)){
            return "redirect:/book";
        }
        return "redirect:/eidt-book/"+id;
    }
}
