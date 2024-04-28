package com.example.hermes.Accounts.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Model.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public void addNewAccount(Account account) {
        Optional<Account> accountByAccountId = accountRepository.findAccountByAccountId(account.getAccountId());
        if (accountByAccountId.isPresent()) {
            throw new IllegalStateException("Account Already Present");
        }
        accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        boolean exists = accountRepository.existsById(accountId);
        if (!exists) {
            throw new IllegalStateException("Account not Present");
        }
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void updateAccount(Long accountId, String name, String phoneno, Double balance, String accountType) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException("Account with Id : " + accountId + " doesn't exist"));
        if (name != null && name.length() > 0 && !Objects.equals(account.getName(), name)) {
            account.setName(name);
        }
        if (phoneno!=null && phoneno != account.getPhoneno()) {
            account.setPhoneno(phoneno);
        }
        if (balance!=null && balance != account.getBalance()) {
            account.setBalance(balance);
        }
        if(accountType!=null && accountType.length()>0 && accountType != account.getAccountType()){
            account.setAccountType(accountType);
        }
    }

    @Transactional
    public void updateAccountForTransaction(Account account) {
        Account existingAccount = accountRepository.findById(account.getId())
                .orElseThrow(() -> new IllegalStateException("Account with Id : " + account.getId() + " doesn't exist"));
        existingAccount.setBalance(account.getBalance());
    }
}
