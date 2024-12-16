package com.example.tododevelopproject.lv1.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {

    // 속성
    private final String title;

    private final String contents;

    private final Long memberId;

    // 생성자
    public TodoRequestDto(String title, String contents, Long memberId) {
        this.title = title;
        this.contents = contents;
        this.memberId = memberId;
    }

    // 기능
}
