package com.example.tododevelopproject.Lv1.dto;

import lombok.Getter;

@Getter
public class TodoResponseDto {

    // 속성
    private final Long id;

    private final String username;

    private final String title;

    private final String contents;

    // 생성자

    public TodoResponseDto(Long id, String username, String title, String contents) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
    }


    // 기능
}
