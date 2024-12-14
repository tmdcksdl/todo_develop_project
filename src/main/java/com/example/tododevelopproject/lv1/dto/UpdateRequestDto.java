package com.example.tododevelopproject.lv1.dto;

import lombok.Getter;

@Getter
public class UpdateRequestDto {

    // 속성
    private final String title;

    private final String contents;

    // 생성자
    public UpdateRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


    // 기능
}
