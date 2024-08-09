package com.nit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "Intel-Transactions"
)
public class Transaction {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long transactionId;
   private String accountNumber;
   private String reciverAccNo;
   private String transactionType;
   private LocalDateTime transactionDate;
   private BigDecimal transactionAmount;
   private String transactionStatus;
   private Long bankAccountid;
   @ManyToOne
   @JoinColumn(
      name = "USER_ID"
   )
   private UserRegister user;
   @ManyToOne
   @JoinColumn(
      name = "ACOUNT_ID"
   )
   private BankAccount account;

   public Long getTransactionId() {
      return this.transactionId;
   }

   public void setTransactionId(Long transactionId) {
      this.transactionId = transactionId;
   }

   public String getAccountNumber() {
      return this.accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public String getTransactionType() {
      return this.transactionType;
   }

   public void setTransactionType(String transactionType) {
      this.transactionType = transactionType;
   }

   public LocalDateTime getTransactionDate() {
      return this.transactionDate;
   }

   public void setTransactionDate(LocalDateTime transactionDate) {
      this.transactionDate = transactionDate;
   }

   public BigDecimal getTransactionAmount() {
      return this.transactionAmount;
   }

   public void setTransactionAmount(BigDecimal transactionAmount) {
      this.transactionAmount = transactionAmount;
   }

   public String getTransactionStatus() {
      return this.transactionStatus;
   }

   public void setTransactionStatus(String transactionStatus) {
      this.transactionStatus = transactionStatus;
   }

   public UserRegister getUser() {
      return this.user;
   }

   public void setUser(UserRegister user) {
      this.user = user;
   }

   public String getRaccountNumber() {
      return this.reciverAccNo;
   }

   public void setRaccountNumber(String reciverAccNo) {
      this.reciverAccNo = reciverAccNo;
   }

   public String getReciverAccNo() {
      return this.reciverAccNo;
   }

   public void setReciverAccNo(String reciverAccNo) {
      this.reciverAccNo = reciverAccNo;
   }

   public Long getBankAccountid() {
      return this.bankAccountid;
   }

   public void setBankAccountid(Long bankAccountid) {
      this.bankAccountid = bankAccountid;
   }

   public String toString() {
      String var10000 = String.valueOf(this.transactionId);
      return "Transaction [transactionId=" + var10000 + ", accountNumber=" + this.accountNumber + ", reciverAccNo=" + this.reciverAccNo + ", transactionType=" + this.transactionType + ", transactionDate=" + String.valueOf(this.transactionDate) + ", transactionAmount=" + String.valueOf(this.transactionAmount) + ", transactionStatus=" + this.transactionStatus + ", user=" + String.valueOf(this.user) + ", bankAccountid=" + String.valueOf(this.bankAccountid) + "]";
   }

   public Transaction(Long transactionId, String accountNumber, String reciverAccNo, String transactionType, LocalDateTime transactionDate, BigDecimal transactionAmount, String transactionStatus, UserRegister user, Long bankAccountid) {
      this.transactionId = transactionId;
      this.accountNumber = accountNumber;
      this.reciverAccNo = reciverAccNo;
      this.transactionType = transactionType;
      this.transactionDate = transactionDate;
      this.transactionAmount = transactionAmount;
      this.transactionStatus = transactionStatus;
      this.user = user;
      this.bankAccountid = bankAccountid;
   }

   public Transaction() {
   }
}
