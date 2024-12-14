package com.example.tododevelopproject.lv1.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    // 속성
    private final String username;

    private final String title;

    private final String contents;

    // 생성자
    public TodoRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    // 기능
}
