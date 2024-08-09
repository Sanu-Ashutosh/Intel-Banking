package com.nit.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(
   name = "Intel_UserRegister"
)
public class UserRegister implements Serializable {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "REG_ID"
   )
   private Long regID;
   @Nonnull
   @Column(
      name = "EMAIL_ID"
   )
   private String emailID;
   @Nonnull
   @Column(
      name = "PASSWORD"
   )
   private String password;
   @OneToMany
   private Set<BankAccount> bankAccounts;
   @OneToMany
   private Set<Transaction> transactions;

   public UserRegister() {
   }

   public Long getRegID() {
      return this.regID;
   }

   public void setRegID(Long regID) {
      this.regID = regID;
   }

   public String getEmailID() {
      return this.emailID;
   }

   public void setEmailID(String emailID) {
      this.emailID = emailID;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String toString() {
      String var10000 = String.valueOf(this.regID);
      return "BankingRegister [regID=" + var10000 + ", emailID=" + this.emailID + ", passward=" + this.password + "]";
   }

   public UserRegister(String emailID, String password) {
      this.emailID = emailID;
      this.password = password;
   }
}
