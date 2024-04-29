package com.example.hermes.Authentication.SignUp.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Model.AccountRepository;
import com.example.hermes.TransactionObserver.AccountObserver;
import com.example.hermes.TransactionObserver.TransactionObservable;

import jakarta.transaction.Transactional;

@Service
public class SignUpService {
    @Autowired
    private final AccountRepository accountRepository;
    
    @Autowired
    private final TransactionObservable transactionObservable;

    public SignUpService(AccountRepository accountRepository, TransactionObservable transactionObservable) {
        this.accountRepository = accountRepository;
        this.transactionObservable = transactionObservable;
    }
    
    public Optional<Account> getLoggedInUser(String username) {
        return accountRepository.findByName(username);
    }

    @Transactional
    public boolean addAccount(String name, String password, String phoneNumber, String accountType) {
        List<Account> allAccounts = accountRepository.findAll();
        System.out.println("All Accounts: " + allAccounts);

        for (Account account : allAccounts) {
            if (Objects.equals(account.getName(), name)
                    && Objects.equals(account.getPhoneno(), phoneNumber)
                    && Objects.equals(account.getAccountType(), accountType)) {
                System.out.println("Account already exists with the same name, phone number, and account type.");
                return false;
            }
        }


        long newAccountId = allAccounts.size() + 1;

        Random random = new Random();
        long randomValue = random.nextInt();
        if(randomValue < 0) randomValue *= -1;

        Account newAccount = new Account(newAccountId, newAccountId, name, phoneNumber, 500.0, accountType, password);
        accountRepository.save(newAccount);

        if (accountType.equals("admin")) {
            transactionObservable.addObserver(new AccountObserver(newAccount));
        }

        System.out.println("Account created successfully.");
        return true;
    }

}
