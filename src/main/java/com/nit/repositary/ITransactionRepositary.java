package com.nit.repositary;

import com.nit.Entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepositary extends JpaRepository<Transaction, Long> {
   List<Transaction> findByaccountNumber(String accountNumber);
}
