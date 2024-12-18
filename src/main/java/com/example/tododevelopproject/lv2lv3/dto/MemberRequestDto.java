package com.example.tododevelopproject.lv2lv3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberRequestDto {

    // 속성
    @NotEmpty
    @Size(max = 6, message = "Please limit it to 6 characters or fewer.")
    private final String username;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message = "Please check the email address format.")
    private final String email;

    @NotBlank
    private final String password;

    // 생성자


    // 기능
}
