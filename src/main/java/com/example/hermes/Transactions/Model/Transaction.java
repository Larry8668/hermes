package com.example.hermes.Transactions.Model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Transaction {
    @Id
    @SequenceGenerator(name = "transactionSeq", sequenceName = "transactionSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
    private Long id;
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private Timestamp  time;

    public Transaction() {
        
    }

    public Transaction(Long id, Long fromAccountId, Long toAccountId, Double amount, Timestamp  time) {
        this.id = id;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.time = time;
    }

    public Transaction(Long fromAccountId, Long toAccountId, Double amount, Timestamp  time) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.time = time;
    }

    public Transaction(Long toAccountId, Long fromAccountId, Double amount){
        this.toAccountId=toAccountId;
        this.fromAccountId=fromAccountId;
        this.amount=amount;
    }

    public Long getId() {
        return id;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public Timestamp  getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTime(Timestamp  time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}
