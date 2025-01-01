package com.example.tododevelopproject.todo.dto;

import com.example.tododevelopproject.todo.entity.Todo;
import com.example.tododevelopproject.member.dto.MemberResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TodoResponseDto {

    // 속성
    private final Long id;

    private final String title;

    private final String contents;

    private final MemberResponseDto member;

    // 생성자

    // 기능
    public static TodoResponseDto toDo(Todo todo) {

        MemberResponseDto memberResponseDto = new MemberResponseDto(todo.getMember().getId(), todo.getMember().getUsername(), todo.getMember().getEmail());

        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(), memberResponseDto);
    }
}
