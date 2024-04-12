package com.example.t2207a_springboot.controller;

import com.example.t2207a_springboot.entities.User;
import com.example.t2207a_springboot.model.request_model.LoginUser;
import com.example.t2207a_springboot.model.request_model.RegisterUser;
import com.example.t2207a_springboot.model.response_model.LoginResponse;
import com.example.t2207a_springboot.service.AuthenticationService;
import com.example.t2207a_springboot.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    public AuthController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUser request){
        User registeredUser = authenticationService.signup(request);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUser request){
        User user = authenticationService.authenticate(request);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
