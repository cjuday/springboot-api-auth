package com.auth.jwt.angular.JWTAuthAngular.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotNull(message = "Email is Required")
    @Email(message = "Invalid Email Format!")
    private String email;

    @NotNull(message = "Password is Required!")
    private String password;

    @NotNull(message = "Full Name is Required!")
    private String fullName;
}
