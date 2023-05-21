package com.example.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

//String EMAIL_REGEXP = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
@Data
@EqualsAndHashCode
public class UserDto {
    private Long id;

    @NotBlank
    @NotNull
    private String surname;
    @NotBlank
    @NotNull
    private String name;
    private String middleName;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthdate;
    @Email
    @NotBlank
    @NotNull
    private String email;
    private String phone;
    private String photoUrl;

}
