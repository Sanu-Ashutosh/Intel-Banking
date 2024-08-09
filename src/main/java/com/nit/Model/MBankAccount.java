package com.nit.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MBankAccount {
   private String fullName;
   private String dateOfBirth;
   private int age;
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
   private String bankAcNo;

   @JsonProperty("fullName")
   public String getFullName() {
      return this.fullName;
   }

   @JsonProperty("fullName")
   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   @JsonProperty("dateOfBirth")
   public String getDateOfBirth() {
      return this.dateOfBirth;
   }

   @JsonProperty("dateOfBirth")
   public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   @JsonProperty("age")
   public int getAge() {
      return this.age;
   }

   @JsonProperty("age")
   public void setAge(int age) {
      this.age = age;
   }

   @JsonProperty("gender")
   public String getGender() {
      return this.gender;
   }

   @JsonProperty("gender")
   public void setGender(String gender) {
      this.gender = gender;
   }

   @JsonProperty("nationality")
   public String getNationality() {
      return this.nationality;
   }

   @JsonProperty("nationality")
   public void setNationality(String nationality) {
      this.nationality = nationality;
   }

   @JsonProperty("residentialAddress")
   public String getResidentialAddress() {
      return this.residentialAddress;
   }

   @JsonProperty("residentialAddress")
   public void setResidentialAddress(String residentialAddress) {
      this.residentialAddress = residentialAddress;
   }

   @JsonProperty("currentAddress")
   public String getCurrentAddress() {
      return this.currentAddress;
   }

   @JsonProperty("currentAddress")
   public void setCurrentAddress(String currentAddress) {
      this.currentAddress = currentAddress;
   }

   @JsonProperty("phoneNumber")
   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   @JsonProperty("phoneNumber")
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   @JsonProperty("emailAddress")
   public String getEmailAddress() {
      return this.emailAddress;
   }

   @JsonProperty("emailAddress")
   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

   @JsonProperty("adhar")
   public String getAdhar() {
      return this.adhar;
   }

   @JsonProperty("adhar")
   public void setAdhar(String adhar) {
      this.adhar = adhar;
   }

   @JsonProperty("governmentId")
   public String getGovernmentId() {
      return this.governmentId;
   }

   @JsonProperty("governmentId")
   public void setGovernmentId(String governmentId) {
      this.governmentId = governmentId;
   }

   @JsonProperty("accountType")
   public String getAccountType() {
      return this.accountType;
   }

   @JsonProperty("accountType")
   public void setAccountType(String accountType) {
      this.accountType = accountType;
   }

   @JsonProperty("initialDepositAmount")
   public Double getInitialDepositAmount() {
      return this.initialDepositAmount;
   }

   @JsonProperty("initialDepositAmount")
   public void setInitialDepositAmount(Double initialDepositAmount) {
      this.initialDepositAmount = initialDepositAmount;
   }

   @JsonProperty("maritalStatus")
   public String getMaritalStatus() {
      return this.maritalStatus;
   }

   @JsonProperty("maritalStatus")
   public void setMaritalStatus(String maritalStatus) {
      this.maritalStatus = maritalStatus;
   }

   @JsonProperty("securityQuestion")
   public String getSecurityQuestion() {
      return this.securityQuestion;
   }

   @JsonProperty("securityQuestion")
   public void setSecurityQuestion(String securityQuestion) {
      this.securityQuestion = securityQuestion;
   }

   @JsonProperty("securityAnswer")
   public String getSecurityAnswer() {
      return this.securityAnswer;
   }

   @JsonProperty("securityAnswer")
   public void setSecurityAnswer(String securityAnswer) {
      this.securityAnswer = securityAnswer;
   }

   @JsonProperty("bankAcNo")
   public String getBankAcNo() {
      return this.bankAcNo;
   }

   @JsonProperty("bankAcNo")
   public void setBankAcNo(String bankAcNo) {
      this.bankAcNo = bankAcNo;
   }

   @JsonProperty("governmentIdType")
   public String getGovernmentIdType() {
      return this.governmentIdType;
   }

   @JsonProperty("governmentIdType")
   public void setGovernmentIdType(String governmentIdType) {
      this.governmentIdType = governmentIdType;
   }

   public String toString() {
      String var10000 = this.fullName;
      return "MBankAccount [fullName=" + var10000 + ", dateOfBirth=" + this.dateOfBirth + ", age=" + this.age + ", gender=" + this.gender + ", nationality=" + this.nationality + ", residentialAddress=" + this.residentialAddress + ", currentAddress=" + this.currentAddress + ", phoneNumber=" + this.phoneNumber + ", emailAddress=" + this.emailAddress + ", adhar=" + this.adhar + ", governmentId=" + this.governmentId + ", accountType=" + this.accountType + ", initialDepositAmount=" + String.valueOf(this.initialDepositAmount) + ", maritalStatus=" + this.maritalStatus + ", securityQuestion=" + this.securityQuestion + ", securityAnswer=" + this.securityAnswer + ", bankAcNo=" + this.bankAcNo + ", governmentIdType=" + this.governmentIdType + "]";
   }
}
