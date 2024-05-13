package com.sonphattran.resumeportal.services.user;

public interface IRegistrationService {
    void registerUser(String username, String password, String confirmPassword);
}
