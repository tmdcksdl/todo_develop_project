package com.example.tododevelopproject.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateRequestDto {

    // 속성
    @NotEmpty
    @Size(max = 15, message = "제목은 15글자 이내로 작성해주세요.")
    private final String title;

    @NotEmpty(message = "내용을 작성해주세요.")
    private final String contents;

    // 생성자

    // 기능
}
