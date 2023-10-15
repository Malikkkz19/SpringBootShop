package ru.malikkkz.SpringShoppp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.malikkkz.SpringShoppp.entity.User;
import ru.malikkkz.SpringShoppp.service.RegistrationService;
import ru.malikkkz.SpringShoppp.util.UserValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserValidator userValidator;

    private final RegistrationService registrationService;

    @Autowired
    public AuthController(UserValidator userValidator, RegistrationService registrationService) {
        this.userValidator = userValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest httpServletRequest, Model model) {
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registerationPage(@ModelAttribute("user") User user) {
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.register(user);

        return "redirect:/auth/login";
    }
}
