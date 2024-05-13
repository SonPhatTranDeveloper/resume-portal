package com.sonphattran.resumeportal.models.form;

import lombok.Data;

@Data
public class RegistrationFormModel {
    private String username;
    private String password;
    private String confirmPassword;
}
