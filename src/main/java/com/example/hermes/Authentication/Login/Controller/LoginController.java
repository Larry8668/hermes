package com.example.hermes.Authentication.Login.Controller;

import com.example.hermes.Accounts.Service.AccountService;
import com.example.hermes.Authentication.Login.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.hermes.Accounts.Model.Account;
import com.example.hermes.Accounts.Service.AccountService;
import com.example.hermes.Authentication.Login.Service.LoginService;

// @RestController
@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ModelAndView loginPage(Model model) {
        return new ModelAndView("login.html");
    }

    @PostMapping
    public String checkValidUserLogin(@RequestParam Long accountId, @RequestParam String password,
            RedirectAttributes redirectAttributes) {
        boolean validUser = loginService.checkUserExists(accountId, password);
        redirectAttributes.addFlashAttribute("message", "Username or Password is Incorrect, Try again!");

        if (validUser) {
            Optional<Account> currUser = loginService.getAccountById(accountId);
            redirectAttributes.addFlashAttribute("currUser", currUser.get());
            System.out.println(currUser);
            if (currUser.get().getAccountType().toLowerCase().equals("admin"))
                return "redirect:/";
            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("errorMessage", "Username or Password is Incorrect, Try again!");
        return "redirect:/login";
    }
}
