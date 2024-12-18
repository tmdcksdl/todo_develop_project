package com.example.tododevelopproject.lv7.dto;

import com.example.tododevelopproject.lv1.dto.TodoResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCommentResponseDto {

    // 속성
    private final Long id;

    private final String contents;

    private final TodoResponseDto todo;

    // 생성자

    // 기능
}
