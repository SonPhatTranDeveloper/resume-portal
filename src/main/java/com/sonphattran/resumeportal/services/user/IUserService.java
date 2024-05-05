package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.errors.UserNotFoundException;
import com.sonphattran.resumeportal.errors.UserUpdateException;
import com.sonphattran.resumeportal.models.User;

public interface IUserService {
    User getUserByUsername(String username) throws UserNotFoundException;
    void updateName(Long id, String firstName, String lastName) throws UserUpdateException;
}
