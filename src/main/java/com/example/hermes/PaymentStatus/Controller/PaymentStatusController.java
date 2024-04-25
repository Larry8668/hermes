package com.example.hermes.PaymentStatus.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.example.hermes.Accounts.Model.Account;

@Controller
public class PaymentStatusController {
    
    @GetMapping("/payment-status")
    public ModelAndView showPaymentStatus(@RequestParam(name = "transactionSuccess", required = false) Boolean transactionSuccess, Model model) {
        Account currUser = (Account) model.asMap().get("fromAccount");
        Account receiverUser = (Account) model.asMap().get("toAccount");
        ModelAndView modelAndView = new ModelAndView("payment-status.html"); 
        
        model.addAttribute("currUser", currUser);
        model.addAttribute("receiverUser", receiverUser);

        modelAndView.addObject("transactionSuccess", transactionSuccess != null ? transactionSuccess : false);
        return modelAndView;
    }
    
}
