package com.example.hermes.AccountView.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.hermes.Accounts.Service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AccountViewController {
    private final AccountService accountService;

    public AccountViewController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ModelAndView getAllAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAccounts());
        return new ModelAndView("account-view.html");
    }
    
}
