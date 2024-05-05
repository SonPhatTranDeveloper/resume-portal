package com.sonphattran.resumeportal.controllers;

import com.sonphattran.resumeportal.authentication.AuthenticationFacade;
import com.sonphattran.resumeportal.errors.UserNotFoundException;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(Model model) {
        return "home/index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Get the user details
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = (String) authentication.getPrincipal();

        // Find the user
        User user = userService.getUserByUsername(username);

        // Set the model details
        model.addAttribute("user", user);
        return "home/home";
    }
}
