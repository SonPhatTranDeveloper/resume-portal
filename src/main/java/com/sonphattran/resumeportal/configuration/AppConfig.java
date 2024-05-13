package com.sonphattran.resumeportal.configuration;

import com.sonphattran.resumeportal.helpers.ElementaryPasswordValidator;
import com.sonphattran.resumeportal.helpers.PasswordValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PasswordValidator passwordValidator() {
        return new ElementaryPasswordValidator();
    }
}
