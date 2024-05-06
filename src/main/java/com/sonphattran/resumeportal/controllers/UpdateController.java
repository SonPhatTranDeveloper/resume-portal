package com.sonphattran.resumeportal.controllers;

import com.sonphattran.resumeportal.models.Education;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.services.user.EducationService;
import com.sonphattran.resumeportal.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UpdateController {
    @Autowired
    private UserService userService;

    @Autowired
    private EducationService educationService;

    @PostMapping("/update/{userId}")
    public RedirectView update(@PathVariable Long userId, @ModelAttribute("user") User user) {
        // Update
        userService.updateName(
                userId,
                user.getFirstName(),
                user.getLastName()
        );

        return new RedirectView("/home");
    }

    @PostMapping("/update/{userId}/education")
    public RedirectView updateEducation(@PathVariable Long userId, @ModelAttribute("user") User user) {
        // Set user
        user.setId(userId);

        // Set education user
        for (Education education : user.getEducation()) {
            education.setUser(user);
        }

        // Delete all and save
        educationService.deleteEducationByUserId(userId);
        educationService.saveAll(user.getEducation());
        return new RedirectView("/home");
    }
}
