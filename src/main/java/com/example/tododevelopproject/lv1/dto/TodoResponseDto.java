package com.example.tododevelopproject.lv1.dto;

import com.example.tododevelopproject.lv1.entity.Todo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TodoResponseDto {

    // 속성
    private final Long id;

    private final String title;

    private final String contents;

    // 생성자

    // 기능
    public static TodoResponseDto toDo(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }
}
