package com.workintech.S19D2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S19D2.dto.RegistrationMember;
import com.workintech.S19D2.entity.Member;
import com.workintech.S19D2.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember) {
        return authenticationService.register(registrationMember.getEmail(),
                registrationMember.getPassword());
    }
}