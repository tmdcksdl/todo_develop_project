package com.example.tododevelopproject.lv2.service;

import com.example.tododevelopproject.lv2.dto.MemberResponseDto;
import com.example.tododevelopproject.lv2.entity.Member;
import com.example.tododevelopproject.lv2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    // 속성
    private final MemberRepository memberRepository;

    // 생성자


    // 기능
    // ::: 회원 생성 서비스
    public MemberResponseDto saveMember(String username, String email) {

        Member member = new Member(username, email);

        Member savedMember = memberRepository.save(member);

        return new MemberResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }

}
