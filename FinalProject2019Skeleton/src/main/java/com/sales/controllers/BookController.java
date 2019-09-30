package com.sales.controllers;

import com.sales.models.Book;
import com.sales.repositories.BookRepository;
import com.sales.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/showBooks")
    public ModelAndView showBooks(ModelAndView model) {
        model.addObject("bookList", bookService.findAll());
        model.setViewName("books");
        return model;
    }

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "addBook";
        }
        bookService.save(book);
        return "redirect:/showBooks";
    }
}
