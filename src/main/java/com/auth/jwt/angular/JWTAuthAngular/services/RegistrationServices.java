package com.auth.jwt.angular.JWTAuthAngular.services;

import com.auth.jwt.angular.JWTAuthAngular.dto.RegistrationRequest;
import com.auth.jwt.angular.JWTAuthAngular.entities.Users;
import com.auth.jwt.angular.JWTAuthAngular.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(RegistrationRequest registrationRequest) {
        if(userRepository.findByEmail(registrationRequest.getEmail()).isPresent()){
            return false;
        }

        Users user = new Users();
        user.setEmail(registrationRequest.getEmail());
        user.setFullName(registrationRequest.getFullName());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        userRepository.save(user);
        return true;
    }
}
