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
    private int phoneno;
    private int balance;

    public Account() {

    }

    public Account(Long id, Long accountId, String name, int phoneno, int balance) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.phoneno = phoneno;
        this.balance = balance;
    }

    public Account(Long accountId, String name, int phoneno, int balance) {
        this.accountId = accountId;
        this.name = name;
        this.phoneno = phoneno;
        this.balance = balance;
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

    public int getPhoneno() {
        return phoneno;
    }

    public int getBalance() {
        return balance;
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

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneno=" + phoneno +
                ", accountId='" + accountId + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}