package com.example.tododevelopproject.member.dto;

import com.example.tododevelopproject.member.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberResponseDto {

    // 속성
    private final Long id;

    private final String username;

    private final String email;

    // 생성자


    // 기능
    public static MemberResponseDto memberDto(Member member) {
        return new MemberResponseDto(member.getId(), member.getUsername(), member.getEmail());
    }
}
