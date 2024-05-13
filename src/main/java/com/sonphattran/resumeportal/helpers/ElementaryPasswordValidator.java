package com.sonphattran.resumeportal.helpers;


public class ElementaryPasswordValidator implements PasswordValidator {
    @Override
    public boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}
