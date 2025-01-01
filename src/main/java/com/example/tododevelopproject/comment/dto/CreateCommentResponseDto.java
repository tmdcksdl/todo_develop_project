package com.example.tododevelopproject.comment.dto;

import com.example.tododevelopproject.todo.dto.TodoResponseDto;
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
