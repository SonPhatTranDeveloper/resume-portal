package com.sonphattran.resumeportal.controllers;

import com.sonphattran.resumeportal.authentication.AuthenticationFacade;
import com.sonphattran.resumeportal.helpers.StringHelper;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private IUserService userService;

    private boolean isLoggedIn() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken);
    }

    private User getLoggedInUser() {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = (String) authentication.getPrincipal();
        return userService.findUserByName(username);
    }

    @GetMapping("/")
    public String index(Model model) {
        // Check if user is logged in
        boolean isLoggedIn = isLoggedIn();

        // Pass to model
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "home/index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Get the user details
        User user = getLoggedInUser();

        // Set the model details
        model.addAttribute("user", user);
        model.addAttribute("educations", user.getEducation());
        return "home/home";
    }

    @GetMapping("/users/{userId}/view")
    public String userView(@PathVariable Long userId, Model model) {
        // Find the owner with specific id
        User owner = userService.findUserById(userId);
        User loggedInUser = getLoggedInUser();

        // Check if owner is owner or profile is public
        if (owner.isVisible() || owner.getId() == loggedInUser.getId()) {
            // Add to model
            model.addAttribute("user", owner);

            // Join the skills
            String skills = StringHelper.joinSkills(owner.getSkills());
            model.addAttribute("skills", skills);
            return "home/resume";
        } else {
            return "home/unavailable";
        }
    }
}
