package com.example.tododevelopproject.member.dto;

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
    @Size(max = 6, message = "이름의 길이는 6글자 이하로 작성해주세요.")
    private final String username;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message = "이메일 형식을 확인해주세요.")
    private final String email;

    @NotBlank
    private final String password;

    // 생성자


    // 기능
}
