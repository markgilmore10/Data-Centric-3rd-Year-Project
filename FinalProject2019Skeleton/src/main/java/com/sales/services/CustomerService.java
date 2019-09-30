package com.sales.services;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.repositories.BookRepository;
import com.sales.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void save(Customer cust) {
        customerRepository.save(cust);
    }

    public Customer findByCid(Long cid) {
        return customerRepository.findOne(cid);
    }
}
