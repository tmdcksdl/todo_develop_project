package com.example.tododevelopproject.lv7.dto;

import com.example.tododevelopproject.lv1.dto.TodoResponseDto;
import com.example.tododevelopproject.lv2lv3.dto.MemberResponseDto;
import com.example.tododevelopproject.lv7.entity.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentResponseDto {

    // 속성
    private final Long id;

    private final String contents;

    private final TodoResponseDto todo;

    // 생성자

    // 기능
    public static CommentResponseDto commentDto(Comment comment) {

        MemberResponseDto memberResponseDto = new MemberResponseDto(comment.getMember().getId(), comment.getMember().getUsername(), comment.getMember().getEmail());

        TodoResponseDto todoResponseDto = new TodoResponseDto(comment.getTodo().getId(),comment.getTodo().getTitle(), comment.getTodo().getContents(), memberResponseDto);

        return new CommentResponseDto(comment.getId(), comment.getContents(), todoResponseDto);
    }
}
