package com.sales.controllers;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.BookRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @GetMapping({"","/"})
    public String index() {
        return "index";
    }

    @GetMapping(value="/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/menu")
    public String menu() {
        return "templates/menu";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/addBook")
    public ModelAndView addBook() {
        return new ModelAndView("addBook", "newBook", new Book());
    }

    @GetMapping("/addCustomer")
    public ModelAndView addCustomer() {
        return new ModelAndView("addCustomer", "newCustomer", new Customer());
    }

    @GetMapping("/newLoan")
    public ModelAndView addLoan() {
        return new ModelAndView("addLoan", "newLoan", new Loan());
    }


    @GetMapping("/deleteLoan")
    public ModelAndView deleteLoan() {
        return new ModelAndView("deleteLoan", "deleteLoan", new Loan());
    }
}
