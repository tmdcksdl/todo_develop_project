package com.example.tododevelopproject.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TodoRequestDto {

    // 속성
    @NotEmpty
    @Size(max = 15, message = "Please limit it to 15 characters or fewer.")
    private final String title;

    @NotEmpty(message = "Contents cannot be empty.")
    private final String contents;

    @NotNull
    private final Long memberId;

    // 생성자

    // 기능
}
