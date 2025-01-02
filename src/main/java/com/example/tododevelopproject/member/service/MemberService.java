package com.example.tododevelopproject.member.service;

import com.example.tododevelopproject.common.exception.InvalidPasswordException;
import com.example.tododevelopproject.common.exception.MemberNotFoundException;
import com.example.tododevelopproject.member.dto.MemberResponseDto;
import com.example.tododevelopproject.member.entity.Member;
import com.example.tododevelopproject.member.repository.MemberRepository;
import com.example.tododevelopproject.common.config.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    // 속성
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 생성자


    // 기능
    // ::: 회원 생성 서비스
    public MemberResponseDto saveMember(String username, String email, String password) {

        String encodePassword = passwordEncoder.encode(password);

        Member member = new Member(username, email, encodePassword);

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

        Member foundMember = memberRepository.findById(id).orElseThrow(() ->
                new MemberNotFoundException("해당 Id를 가진 회원이 존재하지 않습니다."));

        return new MemberResponseDto(foundMember.getId(), foundMember.getUsername(), foundMember.getEmail());
    }

    // ::: 선택 회원 수정 서비스
    @Transactional
    public void updateMember(Long id, String email, String password) {

        Member foundMember = memberRepository.findById(id).orElseThrow(() ->
                new MemberNotFoundException("해당 Id를 가진 회원이 존재하지 않습니다."));

        if (!passwordEncoder.matches(password, foundMember.getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }

        foundMember.update(email);
    }

    // ::: 선택 회원 삭제 서비스
    public void deleteMember(Long id, String password) {

        Member foundMember = memberRepository.findById(id).orElseThrow(() ->
                new MemberNotFoundException("해당 Id를 가진 회원이 존재하지 않습니다."));

        if (passwordEncoder.matches(password, foundMember.getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }

        memberRepository.delete(foundMember);
    }
}
