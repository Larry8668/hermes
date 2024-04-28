package com.example.hermes.Accounts;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Model.AccountRepository;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            Account acc1 = new Account(1L, 1L, "User1", "1234567890", 500.0, "customer", "qwerty");
            Account acc2 = new Account(2L, 2L, "User2", "1234567899", 800.0, "merchant", "12345");

            repository.saveAll(List.of(acc1, acc2));
        };
    }
}
