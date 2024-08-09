package com.nit.services;

import com.nit.Entity.BankAccount;
import com.nit.Entity.UserRegister;
import com.nit.repositary.IBankRegistrationRepositary;
import com.nit.repositary.IBankingAccountRepositary;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingMgmtServiceIMPL implements IBankingMgmtService {
   @Autowired
   private IBankingAccountRepositary ac_repo;
   @Autowired
   private IBankRegistrationRepositary rg_repo;
   private UserRegister register;

   public String registerUser(UserRegister register) {
      register.setEmailID(register.getEmailID().toLowerCase());
      UserRegister save = (UserRegister)this.rg_repo.save(register);
      this.register = register;
      return "Email-ID Register with " + String.valueOf(save.getRegID());
   }

   public Optional<UserRegister> loginUser(String email, String password) {
      Optional<UserRegister> user = this.rg_repo.findByEmailID(email.toLowerCase());
      return user;
   }

   public boolean isEmailAlreadyRegistered(String emailID) {
      Optional<UserRegister> byEmailID = this.rg_repo.findByEmailID(emailID);
      return byEmailID.isPresent();
   }

   public Optional<UserRegister> findByUid(Long uid) {
      return this.rg_repo.findById(uid);
   }

   public String createAccount(BankAccount account) {
      BankAccount save = (BankAccount)this.ac_repo.save(account);
      return save.getBankAcNo();
   }

   public String getLastAccountNumber() {
      return this.ac_repo.findLastAccountNumber();
   }

   public String generateUniqueAccountNumber() {
      String lastAccountNumber = this.ac_repo.findLastAccountNumber();
      String prefix = "754009";
      String newAccountNumber;
      if (lastAccountNumber == null) {
         newAccountNumber = prefix + "0001";
      } else {
         int lastNumber = Integer.parseInt(lastAccountNumber.substring(prefix.length()));
         int newNumber = lastNumber + 1;
         newAccountNumber = prefix + String.format("%04d", newNumber);
      }

      return newAccountNumber;
   }

   public BankAccount getAccountDetails(String accno) {
      return this.ac_repo.findBybankAcNo(accno);
   }

   public List<BankAccount> getAllAccountDetails(String uid) {
      return this.ac_repo.findByuser(uid);
   }

   public BankAccount updateAccount(BankAccount updatedAccount) {
      BankAccount existingAccount = (BankAccount)this.ac_repo.findById(updatedAccount.getAcc_id()).orElseThrow(() -> {
         return new RuntimeException("Account not found");
      });
      existingAccount.setFullName(updatedAccount.getFullName());
      existingAccount.setEmailAddress(updatedAccount.getEmailAddress());
      existingAccount.setDateOfBirth(updatedAccount.getDateOfBirth());
      existingAccount.setAge(updatedAccount.getAge());
      existingAccount.setGender(updatedAccount.getGender());
      existingAccount.setPhoneNumber(updatedAccount.getPhoneNumber());
      existingAccount.setCurrentAddress(updatedAccount.getCurrentAddress());
      existingAccount.setMaritalStatus(updatedAccount.getMaritalStatus());
      return (BankAccount)this.ac_repo.save(existingAccount);
   }
}
