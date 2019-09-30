package com.sales.services;

import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public void updateDueDate() {
        for(Loan loan : loanRepository.findAll()) {

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, loan.getCust().getLoanPeriod());
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");

            loan.setDueDate(sdf.format(c.getTime()));
            loanRepository.save(loan);
        }
    }

    public Iterable<Loan> findAll() {
        return loanRepository.findAll();
    }

    public void save(Loan loan) {
        loanRepository.save(loan);
    }

    public Loan findByBookId(Long bid) {
        return loanRepository.findByBook_Bid(bid);
    }

    public Loan findById(Long lid) {
        return loanRepository.findOne(lid);
    }

    public void delete(Loan loan) {
        loanRepository.delete(loan);
    }
}
