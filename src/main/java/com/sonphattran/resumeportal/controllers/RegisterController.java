package com.sonphattran.resumeportal.controllers;

import com.sonphattran.resumeportal.models.form.RegistrationFormModel;
import com.sonphattran.resumeportal.services.user.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String registerView(Model model) {
        // Create form model
        RegistrationFormModel formModel = new RegistrationFormModel();

        // Add to model
        model.addAttribute("formModel", formModel);
        return "auth/register";
    }

    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute("formModel") RegistrationFormModel formModel) {
        // Get the object
        String username = formModel.getUsername();
        String password = formModel.getPassword();
        String confirmPassword = formModel.getConfirmPassword();

        // Register user
        try {
            registrationService.registerUser(username, password, confirmPassword);
        } catch (RuntimeException e) {
            return new RedirectView("/register?error=" + e.getMessage());
        }

        // Return redirect to login page
        return new RedirectView("/signin?registration");
    }
}
