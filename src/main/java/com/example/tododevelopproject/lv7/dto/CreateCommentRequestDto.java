package com.example.tododevelopproject.lv7.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCommentRequestDto {

    // 속성
    @NotEmpty(message = "댓글 내용을 입력해주세요.")
    private final String contents;

    @NotNull
    private final Long memberId;

    @NotNull
    private final Long todoId;

    // 생성자

    // 기능
}
