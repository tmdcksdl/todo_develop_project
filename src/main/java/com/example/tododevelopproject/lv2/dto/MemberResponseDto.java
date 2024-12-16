package com.example.tododevelopproject.lv2.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    // 속성
    private final Long id;

    private final String username;

    private final String email;

    // 생성자
    public MemberResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // 기능

}
