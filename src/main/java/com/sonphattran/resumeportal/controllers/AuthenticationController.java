package com.sonphattran.resumeportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/signin")
    public String signin() {
        return "auth/signin";
    }
}
