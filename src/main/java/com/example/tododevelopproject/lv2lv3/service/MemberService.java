package com.example.tododevelopproject.lv2lv3.service;

import com.example.tododevelopproject.lv2lv3.dto.MemberResponseDto;
import com.example.tododevelopproject.lv2lv3.entity.Member;
import com.example.tododevelopproject.lv2lv3.repository.MemberRepository;
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
    public MemberResponseDto saveMember(String username, String email, String password) {

        Member member = new Member(username, email, password);

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
    public void updateMember(Long id, String email, String password) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if (password.equals(findMember.getPassword())) {
            findMember.update(email);
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

    }

    // ::: 선택 회원 삭제 서비스
    public void deleteMember(Long id, String password) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if (password.equals(findMember.getPassword())) {
            memberRepository.delete(findMember);
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }


    }
}
