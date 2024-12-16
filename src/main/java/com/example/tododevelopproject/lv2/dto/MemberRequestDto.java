package com.example.tododevelopproject.lv2.dto;

import lombok.Getter;

@Getter
public class MemberRequestDto {

    // 속성
    private final String username;

    private final String email;

    // 생성자
    public MemberRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }


    // 기능
}
