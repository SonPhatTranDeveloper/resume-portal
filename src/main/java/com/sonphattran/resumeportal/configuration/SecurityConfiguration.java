package com.sonphattran.resumeportal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/home*").authenticated()
                            .requestMatchers("/signin*").permitAll()
                            .requestMatchers("/styles/**", "/scripts/**", "/images/**").permitAll()
                            .requestMatchers("/**").permitAll()
                )
                .formLogin(loginConfigurer ->
                        loginConfigurer.loginPage("/signin")
                )
                .build();
    }
}
