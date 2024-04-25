package com.example.hermes.Transactions.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hermes.Transactions.Service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "api/v1/transaction")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/make")
    public ModelAndView showPayementStatus() {
        return new ModelAndView("payment-status.html");
    }
    

    @PostMapping("/make")
    public void makeTransaction(@RequestParam Long fromAccountId,
                                @RequestParam Long toAccountId,
                                @RequestParam Double amount) {
        transactionService.makeTransaction(fromAccountId, toAccountId, amount);
    }
}
