package com.auth.jwt.angular.JWTAuthAngular.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponse {
    private String message;

    public RegistrationResponse(String message) {
        this.message = message;
    }
}
