package com.example.hermes.TransactionObserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TransactionObservable {
    private List<AccountObserver> observers = new ArrayList<>();

    public void addObserver(AccountObserver observer) {
        System.out.println("Added sub -->" + observer);
        observers.add(observer);
    }

    public void notifyObservers() {
        System.out.println("-----------------\n");   
        System.out.println("Notifying subs ...\n");   
        for (TransactionObserver observer : observers) {
            observer.notifyTransactionMade();
        }
    }
}