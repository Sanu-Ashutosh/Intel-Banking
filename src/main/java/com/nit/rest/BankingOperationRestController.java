package com.nit.rest;

import com.nit.Entity.BankAccount;
import com.nit.Entity.Transaction;
import com.nit.Entity.UserRegister;
import com.nit.Model.MBankAccount;
import com.nit.services.IBankingMgmtService;
import com.nit.services.TransactionMgmtserviceIMPL;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/Intel-Banking"})
public class BankingOperationRestController {
   @Autowired
   private IBankingMgmtService service;
   @Autowired
   TransactionMgmtserviceIMPL tService;

   @PostMapping({"/Sign-Up"})
   public ResponseEntity<String> registerUser(@RequestBody UserRegister user) {
      if (user.getEmailID() != null && user.getPassword() != null) {
         boolean isEmailAlreadyRegistered = this.service.isEmailAlreadyRegistered(user.getEmailID().toLowerCase());
         if (isEmailAlreadyRegistered) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Already Registered. Please Sign-In.(failed)");
         }

         if (!isEmailAlreadyRegistered) {
            PrintStream var10000 = System.out;
            String var10001 = user.getEmailID();
            var10000.println(var10001 + " " + user.getPassword());
            this.service.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successfully complited.");
         }
      }

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Internal Server Error...!!!(failed)");
   }

   @PostMapping({"/Sign-In"})
   public ResponseEntity<UserRegister> loginUser(@RequestBody UserRegister user) {
      if (user != null && user.getEmailID() != null && user.getPassword() != null) {
         PrintStream var10000 = System.out;
         String var10001 = user.getEmailID();
         var10000.println("seEmail: " + var10001 + ", Password: " + user.getPassword());
         Optional<UserRegister> loginUser = this.service.loginUser(user.getEmailID().toLowerCase(), user.getPassword());
         return loginUser.isPresent() && ((UserRegister)loginUser.get()).getEmailID().equals(user.getEmailID().toLowerCase()) && ((UserRegister)loginUser.get()).getPassword().equals(user.getPassword()) ? new ResponseEntity((UserRegister)loginUser.get(), HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
      } else {
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
   }

   @PostMapping({"/account-creation"})
   public ResponseEntity<String> createAccount(@RequestBody MBankAccount bankAccount, @RequestParam Long uid) {
      System.out.println("jkj");
      BankAccount account = new BankAccount();
      Optional<UserRegister> byUid = this.service.findByUid(uid);
      if (byUid.isPresent()) {
         account.setUser((UserRegister)byUid.get());
      }

      System.out.println(bankAccount);
      if (bankAccount != null && bankAccount != null) {
         account.setFullName(bankAccount.getFullName());
         account.setDateOfBirth(bankAccount.getDateOfBirth());
         account.setAge((long)bankAccount.getAge());
         account.setGender(bankAccount.getGender());
         account.setNationality(bankAccount.getNationality());
         account.setResidentialAddress(bankAccount.getResidentialAddress());
         account.setPhoneNumber(bankAccount.getPhoneNumber());
         account.setEmailAddress(bankAccount.getEmailAddress());
         account.setAdhar(bankAccount.getAdhar());
         account.setGovernmentId(bankAccount.getGovernmentId());
         account.setAccountType(bankAccount.getAccountType());
         account.setInitialDepositAmount(bankAccount.getInitialDepositAmount());
         account.setMaritalStatus(bankAccount.getMaritalStatus());
         account.setSecurityQuestion(bankAccount.getSecurityQuestion());
         account.setSecurityAnswer(bankAccount.getSecurityAnswer());
         account.setBankAcNo(this.service.generateUniqueAccountNumber());
         account.setCurrentAddress(bankAccount.getCurrentAddress());
         account.setGovernmentIdType(bankAccount.getGovernmentIdType());
      }

      System.out.println(account);
      String createdAccount = this.service.createAccount(account);
      System.out.println(createdAccount);
      return ResponseEntity.ok(createdAccount);
   }

   @PostMapping({"/account-details"})
   public ResponseEntity<BankAccount> getBankAccountDetails(@RequestParam String accNo) {
      BankAccount accountDetails = this.service.getAccountDetails(accNo);
      return accountDetails != null ? new ResponseEntity(accountDetails, HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
   }

   @PostMapping({"/All-accounts/{uid}"})
   public ResponseEntity<List<BankAccount>> getAllBankAccountDetails(@PathVariable String uid) {
      List<BankAccount> allAccountDetails = this.service.getAllAccountDetails(uid);
      return allAccountDetails != null ? new ResponseEntity(allAccountDetails, HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
   }

   @PostMapping({"/update-account"})
   public String updateAccount(@RequestBody BankAccount updatedAccount) {
      this.service.updateAccount(updatedAccount);
      return "{\"success\": true}";
   }

   @PostMapping({"/send-money"})
   public ResponseEntity<String> transferMoney(@RequestParam String senderAccountNo, @RequestParam String receiverAccountNo, @RequestParam BigDecimal amount, @RequestParam Long uid) {
      try {
         System.out.println(senderAccountNo + " " + receiverAccountNo + " " + String.valueOf(amount) + " " + String.valueOf(uid));
         String result = this.tService.transferMoney(senderAccountNo, receiverAccountNo, amount, uid);
         return ResponseEntity.ok(result);
      } catch (RuntimeException var6) {
         return ResponseEntity.badRequest().body(var6.getMessage());
      }
   }

   @GetMapping({"/all-transactions/{accno}"})
   public ResponseEntity<List<Transaction>> showAllTransaction(@PathVariable String accno) {
      List<Transaction> allTransactions = this.tService.getAllTransactions(accno);
      return allTransactions != null ? new ResponseEntity(allTransactions, HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
   }
}
