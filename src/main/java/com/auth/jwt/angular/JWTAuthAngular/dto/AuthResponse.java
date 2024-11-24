package com.auth.jwt.angular.JWTAuthAngular.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String jwtToken;

    public AuthResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
