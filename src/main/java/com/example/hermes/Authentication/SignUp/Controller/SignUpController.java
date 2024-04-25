package com.example.hermes.Authentication.SignUp.Controller;

import com.example.hermes.Authentication.SignUp.Service.SignUpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(path = "/sign-up")
public class SignUpController {

    @Autowired
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public ModelAndView signUpPage() {
        System.out.println("Request got For Sign Up Page Bro.");
        return new ModelAndView("signup.html");
    }

    @PostMapping
    public ModelAndView signUpUser(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam Integer phoneNumber,
            @RequestParam String accountType,
            RedirectAttributes redirectAttributes) {
        Boolean status = signUpService.addAccount(name, password, phoneNumber, accountType);
        if (status) {
            System.out.println("Account Created Successfully!");
            return new ModelAndView("index.html");
        } else {
            return new ModelAndView("error.html");
        }

    }

}
