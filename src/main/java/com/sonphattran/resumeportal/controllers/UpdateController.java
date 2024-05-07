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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UpdateController {
    @Autowired
    private UserService userService;

    @Autowired
    private EducationService educationService;

    @PostMapping("/users/{userId}")
    public RedirectView update(@PathVariable Long userId, @ModelAttribute("user") User user) {
        // Update
        userService.updateName(
                userId,
                user.getFirstName(),
                user.getLastName()
        );

        return new RedirectView("/home");
    }

    @PostMapping("/users/{userId}/education")
    public RedirectView updateEducation(
            @PathVariable Long userId,
            @ModelAttribute("user") User user,
            @RequestParam(value = "new_university", required = false) String[] universities,
            @RequestParam(value = "new_degree", required = false) String[] degree,
            @RequestParam(value = "new_period", required = false) String[] period,
            @RequestParam(value = "new_details", required = false) String[] details
    ) {
        // Set user
        user.setId(userId);

        // Set education user
        for (Education education : user.getEducation()) {
            education.setUser(user);
        }

        // Create a list of education
        // TODO: Fix potential bugs of inconsistent lengths
        if (universities != null) {
            for (int i = 0; i < universities.length; i++) {
                Education newEducation = new Education();
                newEducation.setUser(user);
                newEducation.setUniversity(universities[i]);
                newEducation.setDegree(degree[i]);
                newEducation.setPeriod(period[i]);
                newEducation.setDetails(details[i]);
                user.getEducation().add(newEducation);
            }
        }

        // Delete all and save
        educationService.deleteEducationByUserId(userId);
        educationService.saveAll(user.getEducation());
        return new RedirectView("/home");
    }
}
