package com.sales.repositories;

import com.sales.models.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
    Loan findByBook_Bid(Long bid);
}
