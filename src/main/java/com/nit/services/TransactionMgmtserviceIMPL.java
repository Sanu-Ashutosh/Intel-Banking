package com.nit.services;

import com.nit.Entity.BankAccount;
import com.nit.Entity.Transaction;
import com.nit.Entity.UserRegister;
import com.nit.repositary.IBankingAccountRepositary;
import com.nit.repositary.ITransactionRepositary;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionMgmtserviceIMPL {
   @Autowired
   private ITransactionRepositary transactionRepositary;
   @Autowired
   private IBankingAccountRepositary bankRepo;
   @Autowired
   private IBankingMgmtService service;

   @Transactional
   public String transferMoney(String senderAccountNo, String receiverAccountNo, BigDecimal amount, Long uid) {
      BankAccount senderAccount = this.bankRepo.findBybankAcNo(senderAccountNo);
      BankAccount receiverAccount = this.bankRepo.findBybankAcNo(receiverAccountNo);
      Optional<UserRegister> byUid = this.service.findByUid(uid);
      if (senderAccount != null && receiverAccount != null) {
         if (senderAccount.getInitialDepositAmount() < amount.doubleValue()) {
            throw new RuntimeException("Insufficient funds");
         } else {
            senderAccount.setInitialDepositAmount(senderAccount.getInitialDepositAmount() - amount.doubleValue());
            this.bankRepo.save(senderAccount);
            receiverAccount.setInitialDepositAmount(receiverAccount.getInitialDepositAmount() + amount.doubleValue());
            this.bankRepo.save(receiverAccount);
            Transaction transaction = new Transaction();
            transaction.setAccountNumber(senderAccountNo);
            transaction.setReciverAccNo(receiverAccountNo);
            transaction.setTransactionType("Transfer");
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setTransactionAmount(amount);
            transaction.setTransactionStatus("Sucess");
            transaction.setBankAccountid(senderAccount.getAcc_id());
            if (byUid.isPresent()) {
               transaction.setUser((UserRegister)byUid.get());
            }

            this.transactionRepositary.save(transaction);
            return "Transaction successful " + String.valueOf(transaction.getTransactionId());
         }
      } else {
         throw new RuntimeException("Invalid account details");
      }
   }

   public List<Transaction> getAllTransactions(String accountNumber) {
      return this.transactionRepositary.findByaccountNumber(accountNumber);
   }
}
