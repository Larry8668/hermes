package com.example.hermes.Authentication.SignUp.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Model.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class SignUpService {
    @Autowired
    private final AccountRepository accountRepository;

    public SignUpService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public boolean addAccount(String name, String password, int phoneNumber, String accountType) {
        List<Account> allAccounts = accountRepository.findAll();
        System.out.println("All Accounts: " + allAccounts);

        // Check if an account with the same name, phone number, and account type already exists
        for (Account account : allAccounts) {
            if (Objects.equals(account.getName(), name)
                    && Objects.equals(account.getPhoneno(), phoneNumber)
                    && Objects.equals(account.getAccountType(), accountType)) {
                System.out.println("Account already exists with the same name, phone number, and account type.");
                return false;
            }
        }


        long newAccountId = allAccounts.size() + 1;

        // Generate a random value for the second parameter
        Random random = new Random();
        long randomValue = random.nextInt();
        if(randomValue < 0) randomValue *= -1;

        // Create a new Account object with the provided details
        Account newAccount = new Account(newAccountId, randomValue, name, phoneNumber, 0.0, accountType, password);
        accountRepository.save(newAccount);

        System.out.println("Account created successfully.");
        return true;
    }

}
