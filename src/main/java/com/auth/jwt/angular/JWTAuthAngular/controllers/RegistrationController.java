package com.auth.jwt.angular.JWTAuthAngular.controllers;

import com.auth.jwt.angular.JWTAuthAngular.dto.RegistrationRequest;
import com.auth.jwt.angular.JWTAuthAngular.dto.RegistrationResponse;
import com.auth.jwt.angular.JWTAuthAngular.services.RegistrationServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationServices registrationServices;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        boolean isRegistered = registrationServices.registerUser(registrationRequest);

        if(isRegistered) {
            return ResponseEntity.ok(new RegistrationResponse("User Registered Successfully!"));
        }else{
            return ResponseEntity.status(400).body(new RegistrationResponse("Email Already Exists!"));
        }
    }
}
