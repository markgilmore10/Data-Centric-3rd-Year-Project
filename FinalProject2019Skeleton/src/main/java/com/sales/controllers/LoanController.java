package com.sales.controllers;

import com.sales.exceptions.NotFoundException;
import com.sales.models.Loan;
import com.sales.services.BookService;
import com.sales.services.CustomerService;
import com.sales.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoanController {
    @Autowired
    private LoanService loanService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
        ModelAndView model= new ModelAndView("addLoan");
        model.addObject("error", ex.getMessage());
        return model;
    }

    @GetMapping("/showLoans")
    public ModelAndView showLoans(ModelAndView model) {
        loanService.updateDueDate();
        model.addObject("listLoans", loanService.findAll());
        model.setViewName("loans");
        return model;
    }

    @PostMapping("/newLoan")
    public ModelAndView addCustomer(@Valid @ModelAttribute("newLoan") Loan loan,
                                    BindingResult result, ModelAndView model) throws NotFoundException {
        if (result.hasErrors()) {
            model.setViewName("addLoan");
            return model;
        }

        List<String> error = new ArrayList<>();

        Loan curLoan = loanService.findByBookId(loan.getBook().getBid());
        if(curLoan != null){
            error.add("Book: " + curLoan.getBook().getBid() + " (" + curLoan.getBook().getTitle() + ") already on loan  to Customer: " + curLoan.getCust().getcId() + " (" +curLoan.getCust().getcName() + ")");
        }
        else {
            if (bookService.findByBid(loan.getBook().getBid()) == null) {
                error.add("No such book: " + loan.getBook().getBid());
            }
            if (customerService.findByCid(loan.getCust().getcId()) == null) {
                error.add("No such customer: " + loan.getCust().getcId());
            }
        }

        if(!error.isEmpty())
            throw new NotFoundException(error);

        loanService.save(loan);
        model.setViewName("redirect:/showLoans");

        return model;
    }

    @PostMapping("/deleteLoan")
    public ModelAndView deleteLoan(@Valid @ModelAttribute("deleteLoan") Loan loan,
                                   BindingResult result,
                           ModelAndView model) throws NotFoundException {

        if (result.hasErrors()) {
            model.setViewName("deleteLoan");
            return model;
        }

        List<String> error = new ArrayList<>();
        if(loan.getLid() == null){
            error.add("may not be empty");
        }
        else if(loanService.findById(loan.getLid()) == null){
            error.add("No such loan: " + loan.getLid());
        }

        if(!error.isEmpty())
            throw new NotFoundException(error);

        loanService.delete(loan);
        model.setViewName("redirect:/showLoans");

        return model;
    }
}
