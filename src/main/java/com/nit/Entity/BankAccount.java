package com.nit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(
   name = "Intel_Account"
)
public class BankAccount implements Serializable {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long acc_id;
   private String bankAcNo;
   private String fullName;
   private String dateOfBirth;
   private long age;
   private String gender;
   private String nationality;
   private String residentialAddress;
   private String currentAddress;
   private String phoneNumber;
   private String emailAddress;
   private String governmentIdType;
   private String governmentId;
   private String adhar;
   private String accountType;
   private Double initialDepositAmount;
   private String maritalStatus;
   private String securityQuestion;
   private String securityAnswer;
   @ManyToOne
   @JoinColumn(
      name = "USER_ID"
   )
   private UserRegister user;
   @OneToMany
   private Set<Transaction> transactions;

   public Long getAcc_id() {
      return this.acc_id;
   }

   public void setAcc_id(Long acc_id) {
      this.acc_id = acc_id;
   }

   public String getBankAcNo() {
      return this.bankAcNo;
   }

   public void setBankAcNo(String bankAcNo) {
      this.bankAcNo = bankAcNo;
   }

   public String getFullName() {
      return this.fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public String getDateOfBirth() {
      return this.dateOfBirth;
   }

   public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   public long getAge() {
      return this.age;
   }

   public void setAge(long age) {
      this.age = age;
   }

   public String getGender() {
      return this.gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getNationality() {
      return this.nationality;
   }

   public void setNationality(String nationality) {
      this.nationality = nationality;
   }

   public String getResidentialAddress() {
      return this.residentialAddress;
   }

   public void setResidentialAddress(String residentialAddress) {
      this.residentialAddress = residentialAddress;
   }

   public String getCurrentAddress() {
      return this.currentAddress;
   }

   public void setCurrentAddress(String currentAddress) {
      this.currentAddress = currentAddress;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmailAddress() {
      return this.emailAddress;
   }

   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

   public String getAdhar() {
      return this.adhar;
   }

   public void setAdhar(String adhar) {
      this.adhar = adhar;
   }

   public String getGovernmentIdType() {
      return this.governmentIdType;
   }

   public void setGovernmentIdType(String governmentIdType) {
      this.governmentIdType = governmentIdType;
   }

   public String getGovernmentId() {
      return this.governmentId;
   }

   public void setGovernmentId(String governmentId) {
      this.governmentId = governmentId;
   }

   public String getAccountType() {
      return this.accountType;
   }

   public void setAccountType(String accountType) {
      this.accountType = accountType;
   }

   public Double getInitialDepositAmount() {
      return this.initialDepositAmount;
   }

   public void setInitialDepositAmount(Double initialDepositAmount) {
      this.initialDepositAmount = initialDepositAmount;
   }

   public String getMaritalStatus() {
      return this.maritalStatus;
   }

   public void setMaritalStatus(String maritalStatus) {
      this.maritalStatus = maritalStatus;
   }

   public String getSecurityQuestion() {
      return this.securityQuestion;
   }

   public void setSecurityQuestion(String securityQuestion) {
      this.securityQuestion = securityQuestion;
   }

   public String getSecurityAnswer() {
      return this.securityAnswer;
   }

   public void setSecurityAnswer(String securityAnswer) {
      this.securityAnswer = securityAnswer;
   }

   public UserRegister getUser() {
      return this.user;
   }

   public void setUser(UserRegister user) {
      this.user = user;
   }

   public String toString() {
      String var10000 = String.valueOf(this.acc_id);
      return "BankAccount [acc_id=" + var10000 + ", bankAcNo=" + this.bankAcNo + ", fullName=" + this.fullName + ", dateOfBirth=" + this.dateOfBirth + ", age=" + this.age + ", gender=" + this.gender + ", nationality=" + this.nationality + ", residentialAddress=" + this.residentialAddress + ", currentAddress=" + this.currentAddress + ", phoneNumber=" + this.phoneNumber + ", emailAddress=" + this.emailAddress + ", governmentIdType=" + this.governmentIdType + ", governmentId=" + this.governmentId + ", adhar=" + this.adhar + ", accountType=" + this.accountType + ", initialDepositAmount=" + String.valueOf(this.initialDepositAmount) + ", maritalStatus=" + this.maritalStatus + ", securityQuestion=" + this.securityQuestion + ", securityAnswer=" + this.securityAnswer + ", user=" + String.valueOf(this.user.getRegID()) + "]";
   }

   public BankAccount(Long acc_id, String bankAcNo, String fullName, String dateOfBirth, long age, String gender, String nationality, String residentialAddress, String currentAddress, String phoneNumber, String emailAddress, String governmentIdType, String governmentId, String adhar, String accountType, Double initialDepositAmount, String maritalStatus, String securityQuestion, String securityAnswer, UserRegister user) {
      this.acc_id = acc_id;
      this.bankAcNo = bankAcNo;
      this.fullName = fullName;
      this.dateOfBirth = dateOfBirth;
      this.age = age;
      this.gender = gender;
      this.nationality = nationality;
      this.residentialAddress = residentialAddress;
      this.currentAddress = currentAddress;
      this.phoneNumber = phoneNumber;
      this.emailAddress = emailAddress;
      this.governmentIdType = governmentIdType;
      this.governmentId = governmentId;
      this.adhar = adhar;
      this.accountType = accountType;
      this.initialDepositAmount = initialDepositAmount;
      this.maritalStatus = maritalStatus;
      this.securityQuestion = securityQuestion;
      this.securityAnswer = securityAnswer;
      this.user = user;
   }

   public BankAccount() {
   }
}
