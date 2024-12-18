package com.example.tododevelopproject.lv4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequestDto {

    // 속성
    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message = "Please check the email address format.")
    private final String email;

    @NotBlank
    @Size(max = 10, message = "Please limit it to 10 characters or fewer.")
    private final String password;

    // 생성자

    // 기능
}
