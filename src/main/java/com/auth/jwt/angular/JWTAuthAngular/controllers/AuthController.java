package com.auth.jwt.angular.JWTAuthAngular.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwt.angular.JWTAuthAngular.dto.AuthRequest;
import com.auth.jwt.angular.JWTAuthAngular.dto.AuthResponse;
import com.auth.jwt.angular.JWTAuthAngular.entities.Users;
import com.auth.jwt.angular.JWTAuthAngular.repositories.UserRepository;
import com.auth.jwt.angular.JWTAuthAngular.Utilties.JWTUtil;

import java.util.Optional;

@RestController
public class AuthController {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest authRequest) {
        Optional<Users> usersOptional = userRepository.findByEmail(authRequest.getEmail());

        if(usersOptional.isPresent()) {
            Users user = usersOptional.get();

            if(passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                String jwtToken = jwtUtil.generateToken(user.getEmail());
                return ResponseEntity.ok(new AuthResponse(jwtToken));
            }
        }

        return ResponseEntity.status(401).body(null);
    }


}
