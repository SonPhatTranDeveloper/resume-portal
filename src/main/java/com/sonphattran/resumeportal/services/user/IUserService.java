package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.errors.UserNotFoundException;
import com.sonphattran.resumeportal.models.User;

public interface IUserService {
    User getUserByUsername(String username) throws UserNotFoundException;
}
