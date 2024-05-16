package com.sonphattran.resumeportal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/home*").authenticated()
                            .requestMatchers("/signin*").permitAll()
                            .requestMatchers("/signout*").permitAll()
                            .requestMatchers("/register*").permitAll()
                            .requestMatchers("/styles/**",
                                    "/scripts/**",
                                    "/images/**",
                                    "/h2-console/**").permitAll()
                            .requestMatchers("/**").permitAll()
                )
                .formLogin(loginConfigurer ->
                        loginConfigurer.loginPage("/signin")
                )
                .logout(logoutConfigurer -> logoutConfigurer
                        .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .build();
    }
}
