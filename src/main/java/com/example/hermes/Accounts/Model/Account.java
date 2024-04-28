package com.example.hermes.Accounts.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(name = "accountSeq", sequenceName = "accountSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSeq")

    private Long id;
    private Long accountId;
    private String name;
    private String phoneno;
    private Double balance;
    private String accountType;
    private String password;

    public Account() {

    }

    public Account(Long id, Long accountId, String name, String phoneno, Double balance, String accountType, String password) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.phoneno = phoneno;
        this.balance = balance;
        this.accountType = accountType;
        this.password = password;
    }

    public Account(Long accountId, String name, String phoneno, Double balance, String accountType, String password) {
        this.accountId = accountId;
        this.name = name;
        this.phoneno = phoneno;
        this.balance = balance;
        this.accountType = accountType;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public Double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPassword(){
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setBalance(Double balance) {
        this.balance = balance;

    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneno=" + phoneno +
                ", accountId='" + accountId + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}