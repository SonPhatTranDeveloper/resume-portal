package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.errors.UserNotFoundException;
import com.sonphattran.resumeportal.errors.UserUpdateException;
import com.sonphattran.resumeportal.models.User;
import com.sonphattran.resumeportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> new UserNotFoundException("User not found: " + username));
    }

    @Override
    public void updateName(Long id, String firstName, String lastName) throws UserUpdateException {
        userRepository.updateName(id, firstName, lastName);
    }
}
