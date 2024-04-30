package com.example.hermes.Home.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Authentication.Login.Service.LoginService;
import com.example.hermes.Transactions.Service.TransactionService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LoginService loginService;

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
            @RequestParam("amount") Double amount, RedirectAttributes redirectAttributes) {
        try {
            Optional<Account> fromAccount = loginService.getAccountById(fromAccountId);
            Optional<Account> toAccount = loginService.getAccountById(toAccountId);

            // Add fromAccount and toAccount as flash attributes
            if (fromAccount.isPresent()) {
                redirectAttributes.addFlashAttribute("fromAccount", fromAccount.get());
            }
            if (toAccount.isPresent()) {
                redirectAttributes.addFlashAttribute("toAccount", toAccount.get());
            }
            if (toAccount.isPresent() && "merchant".equalsIgnoreCase(toAccount.get().getAccountType())) {
                double cashbackPercentage = 0.05;
                double cashbackAmount = amount * cashbackPercentage;
                redirectAttributes.addFlashAttribute("reward", cashbackAmount);
            }            

            transactionService.makeTransaction(fromAccountId, toAccountId, amount);
            return "redirect:/payment-status?transactionSuccess=true";
        } catch (Exception e) {
            return "redirect:/payment-status?transactionSuccess=false";
        }
    }
}
