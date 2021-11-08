package com.jwtsample.controllers;

import com.jwtsample.dtos.ApiResponse;
import com.jwtsample.config.CustomAuthenticationToken;
import com.jwtsample.config.JwtAuthenticationResponse;
import com.jwtsample.config.JwtTokenProvider;
import com.jwtsample.dtos.LoginRequest;
import com.jwtsample.dtos.SignupRequest;
import com.jwtsample.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Profile("!test")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new CustomAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword(),
                        loginRequest.getAccessId()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        System.out.println("Results "+authentication.getName()+" principal "+authentication.getPrincipal().toString());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, authentication.getPrincipal()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        authenticationService.signupUser(signupRequest);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }
}