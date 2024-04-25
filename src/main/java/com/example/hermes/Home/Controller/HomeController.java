package com.example.hermes.Home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Transactions.Service.TransactionService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {

    @Autowired
    private TransactionService transactionService;
    
    @GetMapping("/home")
    public ModelAndView homePage(Model model) {
        Account currUser = (Account) model.asMap().get("currUser");
        if (currUser != null) {
            model.addAttribute("currUser", currUser);
        }
        return new ModelAndView("home.html");
    }

    @PostMapping("/transaction/make")
    public String handleTransaction(@RequestParam("fromAccountId") Long fromAccountId,
                                    @RequestParam("toAccountId") Long toAccountId,
                                    @RequestParam("amount") Double amount) {
        try {
            transactionService.makeTransaction(fromAccountId, toAccountId, amount);
            return "redirect:/payment-status?transactionSuccess=true";
        } catch (Exception e) {
            return "redirect:/payment-status?transactionSuccess=false";
        }
    }
}
