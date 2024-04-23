package com.example.hermes.Transactions.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.hermes.Transactions.Model.Transaction;
import com.example.hermes.Transactions.Model.TransactionRepository;
import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Service.AccountService;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final AccountService accountService;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void makeTransaction(Long fromAccountId, Long toAccountId, int amount) {
        Optional<Account> optionalFromAccount = accountService.getAccountById(fromAccountId);
        Optional<Account> optionalToAccount = accountService.getAccountById(toAccountId);

        Account fromAccount = optionalFromAccount
                .orElseThrow(() -> new IllegalArgumentException("Invalid 'from' account."));
        Account toAccount = optionalToAccount.orElseThrow(() -> new IllegalArgumentException("Invalid 'to' account."));

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in the from account.");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountService.updateAccountForTransaction(fromAccount);
        accountService.updateAccountForTransaction(toAccount);

        Transaction transaction = new Transaction(fromAccountId, toAccountId, amount);
        transactionRepository.save(transaction);
    }

}
