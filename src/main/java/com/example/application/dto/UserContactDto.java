package com.example.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserContactDto {
    @Email
    @NotBlank
    @NotNull
    private String email;
    private String phone;
}
