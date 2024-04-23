package com.example.hermes.Authentication.Login.Controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.hermes.Accounts.Service.AccountService;
import com.example.hermes.Authentication.Login.Service.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ModelAndView loginPage(Model model) {
        // return "login.html";
        return new ModelAndView("login.html");
    }

    @PostMapping
    public void checkValidUserLogin(@RequestParam Long accountId, @RequestParam String password, RedirectAttributes redirectAttributes) {
        boolean validUser = loginService.checkUserExists(accountId, password);
        System.out.println(validUser);
        redirectAttributes.addFlashAttribute("message", "Form submitted successfully!");

        if(validUser){
            System.out.println("Valid User");
            
        }
    }
}
