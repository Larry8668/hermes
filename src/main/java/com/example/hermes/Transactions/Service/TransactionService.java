package com.example.hermes.Transactions.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.hermes.Transactions.Model.Transaction;
import com.example.hermes.Transactions.Model.TransactionRepository;
import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Service.AccountService;
import com.example.hermes.TransactionObserver.TransactionObservable;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final AccountService accountService;

    @Autowired
    private final TransactionObservable transactionObservable;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService, TransactionObservable transactionObservable) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.transactionObservable = transactionObservable;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void makeTransaction(Long fromAccountId, Long toAccountId, Double amount) {
        Optional<Account> optionalFromAccount = accountService.getAccountById(fromAccountId);
        Optional<Account> optionalToAccount = accountService.getAccountById(toAccountId);
    
        Account fromAccount = optionalFromAccount.orElseThrow(() -> new IllegalArgumentException("Invalid 'from' account."));
        Account toAccount = optionalToAccount.orElseThrow(() -> new IllegalArgumentException("Invalid 'to' account."));
    
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in the from account.");
        }
    
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
    
        accountService.updateAccountForTransaction(fromAccount);
        accountService.updateAccountForTransaction(toAccount);
    
        transactionObservable.notifyObservers();

        if (toAccount.getAccountType().equals("merchant")) {
            Double cashbackPercentage = 0.05;
            Double cashbackAmount = amount * cashbackPercentage;
            fromAccount.setBalance(fromAccount.getBalance() + cashbackAmount);
            accountService.updateAccountForTransaction(fromAccount);
        }

        LocalDateTime currentTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentTime);
    
        Transaction transaction = new Transaction(toAccountId, fromAccountId, amount);
        transaction.setTime(timestamp);
        transactionRepository.save(transaction);
    }

}
