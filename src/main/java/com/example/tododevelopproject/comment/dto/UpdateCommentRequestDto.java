package com.example.tododevelopproject.comment.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateCommentRequestDto {

    // 속성
    @NotEmpty(message = "댓글 내용을 입력해주세요.")
    private final String contents;

    // 생성자

    // 기능
}
