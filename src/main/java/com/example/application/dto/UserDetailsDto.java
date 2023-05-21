package com.example.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDetailsDto {
    @NotBlank
    @NotNull
    private String surname;
    @NotBlank
    @NotNull
    private String name;
    private String middleName;
    @NotNull
    private LocalDate birthdate;
}
