package com.sonphattran.resumeportal.helpers;

public class ElementaryUserNameValidator implements UserNameValidator {
    private boolean isLongEnough(String username) {
        return username.length() >= 6;
    }

    private boolean containsLetterAndDigits(String username) {
        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isUserNameValid(String username) {
        return isLongEnough(username) && containsLetterAndDigits(username);
    }
}
