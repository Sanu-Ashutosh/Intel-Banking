package com.nit.repositary;

import com.nit.Entity.BankAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBankingAccountRepositary extends JpaRepository<BankAccount, Long> {
   @Query("SELECT bankAcNo FROM BankAccount ORDER BY bankAcNo DESC LIMIT 1")
   String findLastAccountNumber();

   BankAccount findBybankAcNo(String accno);

   @Query("SELECT b FROM BankAccount b WHERE b.user.regID = :uid")
   List<BankAccount> findByuser(String uid);
}
