package com.example.hermes.Accounts.Model;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from Account a where a.accountId = ?1")
    Optional<Account> findAccountByAccountId(Long accountId);

    Optional<Account> findByAccountIdAndPassword(Long accountId, String password);

    Optional<Account> findByName(String name);

    List<Account> findAll();
    
}
