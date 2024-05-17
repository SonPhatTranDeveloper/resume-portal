package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.errors.UserRegistrationException;
import com.sonphattran.resumeportal.helpers.PasswordValidator;
import com.sonphattran.resumeportal.helpers.UserNameValidator;
import com.sonphattran.resumeportal.models.Education;
import com.sonphattran.resumeportal.models.Experience;
import com.sonphattran.resumeportal.models.Skill;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.repositories.EducationRepository;
import com.sonphattran.resumeportal.repositories.ExperienceRepository;
import com.sonphattran.resumeportal.repositories.SkillRepository;
import com.sonphattran.resumeportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService implements IRegistrationService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    PasswordValidator passwordValidator;

    @Autowired
    UserNameValidator userNameValidator;

    private void initialiseEducation(User user) {
        // Create a template for education
        Education education = new Education();
        education.setUser(user);
        education.setDegree("Your degree");
        education.setPeriod("Degree Period");
        education.setUniversity("Your university");
        education.setDetails("-- Start each bullet point with two dashes");
        educationRepository.save(education);
    }

    private void initializeExperience(User user) {
        // Create a template for experience
        Experience experience = new Experience();
        experience.setUser(user);
        experience.setTitle("Your title");
        experience.setPeriod("Experience period");
        experience.setCompany("Your company");
        experience.setDescription("-- Start each buller point with two dashes");
        experienceRepository.save(experience);
    }

    private void initializeSkill(User user) {
        // Create a template for skill
        Skill skill = new Skill();
        skill.setUser(user);
        skill.setName("Your skill");
        skillRepository.save(skill);
    }

    @Override
    public void registerUser(String username, String password, String confirmPassword) {
        // Create new user, set username, password and role
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles("USER");

        // Check if any is black
        if (username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            throw new UserRegistrationException("Username or password cannot be empty");
        }

        // Check if password confirmation matches
        if (!password.equals(confirmPassword)) {
            throw new UserRegistrationException("Password and confirmation do not match");
        }

        // Check if user does not exist
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            throw new UserRegistrationException("User with this username already exists");
        }

        // Check if username is valid
        if (!userNameValidator.isUserNameValid(username)) {
            throw new UserRegistrationException("Username must be longer than 6 characters and contains letters (a-z) and digits (0-9).");
        }

        // Check if password is valid
        if (!passwordValidator.isPasswordValid(password)) {
            throw new UserRegistrationException("Invalid password (needs to be 8 characters or longer)");
        }

        // Register new user
        // Encode password
        user.setPassword(passwordEncoder.encode(password));
        User savedUser = userRepository.save(user);

        // Initialize the information
        initialiseEducation(savedUser);
        initializeExperience(savedUser);
        initializeSkill(savedUser);
    }
}
