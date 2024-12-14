package com.example.tododevelopproject.lv1.dto;

import com.example.tododevelopproject.lv1.entity.Todo;
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
    public static TodoResponseDto toDo(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getUsername(), todo.getTitle(), todo.getContents());
    }
}
