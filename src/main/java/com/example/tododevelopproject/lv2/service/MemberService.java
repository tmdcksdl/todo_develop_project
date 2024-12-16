package com.example.tododevelopproject.lv2.service;

import com.example.tododevelopproject.lv2.dto.MemberResponseDto;
import com.example.tododevelopproject.lv2.entity.Member;
import com.example.tododevelopproject.lv2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    // ::: 전체 회원 조회 서비스
    public List<MemberResponseDto> findAll() {

        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::memberDto)
                .toList();
    }

    // ::: 선택 회원 조회 서비스
    public MemberResponseDto findById(Long id) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        return new MemberResponseDto(findMember.getId(), findMember.getUsername(), findMember.getEmail());
    }

    // ::: 선택 회원 수정 서비스
    @Transactional
    public void updateMember(Long id, String email) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        findMember.update(email);
    }
}
