package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.errors.UserRegistrationException;
import com.sonphattran.resumeportal.helpers.PasswordValidator;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService implements IRegistrationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordValidator passwordValidator;

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

        // Check if password is valid
        if (!passwordValidator.isPasswordValid(password)) {
            throw new UserRegistrationException("Invalid password (needs to be 8 characters or longer)");
        }

        // Register new user
        userRepository.save(user);
    }
}
