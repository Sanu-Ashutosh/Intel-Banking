package com.nit.services;

import com.nit.Entity.BankAccount;
import com.nit.Entity.UserRegister;
import java.util.List;
import java.util.Optional;

public interface IBankingMgmtService {
   String registerUser(UserRegister register);

   Optional<UserRegister> loginUser(String email, String password);

   boolean isEmailAlreadyRegistered(String emailID);

   Optional<UserRegister> findByUid(Long uid);

   String createAccount(BankAccount account);

   String getLastAccountNumber();

   String generateUniqueAccountNumber();

   BankAccount getAccountDetails(String accno);

   List<BankAccount> getAllAccountDetails(String uid);

   BankAccount updateAccount(BankAccount updatedAccount);
}
