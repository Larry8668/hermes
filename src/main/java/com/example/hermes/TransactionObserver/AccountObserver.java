package com.example.hermes.TransactionObserver;

import com.example.hermes.Accounts.Model.Account;

public class AccountObserver implements TransactionObserver {
    private final Account account;

    public AccountObserver(Account account) {
        this.account = account;
    }

    @Override
    public void notifyTransactionMade() {
        if (account.getAccountType().equals("admin")) {
            System.out.println("----------------- \n");
            System.out.println("Admin with ID " + account.getId() + " and name " + account.getName() + " was informed about the transaction. \n");
            System.out.println("-----------------");
        }
    }
}
