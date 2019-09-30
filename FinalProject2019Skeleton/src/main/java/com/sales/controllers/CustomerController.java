package com.sales.controllers;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;
import com.sales.services.CustomerService;
import com.sales.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private LoanService loanService;

    @GetMapping("/showCustomers")
    public ModelAndView showCustomers(ModelAndView model) {
        model.setViewName("customers");
        model.addObject("customerList", customerService.findAll());
        model.addObject("loanList", loanService.findAll());
        return model;
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult result){
        if (result.hasErrors()) {
            return "addCustomer";
        }
        customerService.save(customer);
        return "redirect:/showCustomers";
    }
}
