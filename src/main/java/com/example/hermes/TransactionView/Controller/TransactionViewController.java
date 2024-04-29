package com.example.hermes.TransactionView.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.hermes.Transactions.Service.TransactionService;

@Controller
public class TransactionViewController {

    private final TransactionService transactionService;

    public TransactionViewController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ModelAndView getAllTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return new ModelAndView("transactions.html");
    }
}
