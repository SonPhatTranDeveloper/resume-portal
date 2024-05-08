package com.sonphattran.resumeportal.controllers;

import com.sonphattran.resumeportal.models.Education;
import com.sonphattran.resumeportal.models.Skill;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.services.user.EducationService;
import com.sonphattran.resumeportal.services.user.SkillService;
import com.sonphattran.resumeportal.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;


@Controller
public class UpdateController {
    @Autowired
    private UserService userService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private SkillService skillService;

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
        // Check if education exists
        if (user.getEducation() == null) {
            user.setEducation(new ArrayList<>());
        }

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

    @GetMapping("/users/{userId}/education/delete/{educationId}")
    public RedirectView removeEducation(@PathVariable Long userId, @PathVariable Long educationId) {
        // Remove education id
        educationService.deleteEducationById(educationId);
        return new RedirectView("/home");
    }

    @PostMapping("/users/{userId}/skills")
    public RedirectView updateSkills(
            @PathVariable Long userId,
            @ModelAttribute("user") User user,
            @RequestParam(value = "new_skill", required = false) String[] newSkill) {
        // Set user
        user.setId(userId);

        // Create user skills
        if (user.getSkills() == null) {
            user.setSkills(new ArrayList<>());
        }

        // Set the skill user id
        for (Skill skill : user.getSkills()) {
            skill.setUser(user);
        }

        // Add new skills
        if (newSkill != null) {
            for (String mySkill : newSkill) {
                // Create new skill
                Skill skill = new Skill();
                skill.setUser(user);
                skill.setName(mySkill);

                // Add to user skill
                user.getSkills().add(skill);
            }
        }

        // Delete all and save
        skillService.deleteSkillByUserId(userId);
        skillService.saveAll(user.getSkills());
        return new RedirectView("/home");
    }

    @GetMapping("/users/{userId}/skills/delete/{skillId}")
    public RedirectView removeSkill(
            @PathVariable Long userId,
            @PathVariable Long skillId) {
        skillService.deleteSkillById(skillId);
        return new RedirectView("/home");
    }
}
