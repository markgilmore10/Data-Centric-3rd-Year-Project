package com.sales.services;

import com.sales.models.Book;
import com.sales.models.Loan;
import com.sales.repositories.BookRepository;
import com.sales.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findByBid(Long bid) {
        return bookRepository.findOne(bid);
    }
}
