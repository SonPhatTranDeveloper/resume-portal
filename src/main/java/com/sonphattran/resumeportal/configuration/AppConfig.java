package com.sonphattran.resumeportal.configuration;

import com.sonphattran.resumeportal.helpers.ElementaryPasswordValidator;
import com.sonphattran.resumeportal.helpers.PasswordValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
    @Bean
    public PasswordValidator passwordValidator() {
        return new ElementaryPasswordValidator();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
