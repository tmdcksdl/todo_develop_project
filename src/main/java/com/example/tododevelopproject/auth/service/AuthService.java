package com.example.tododevelopproject.auth.service;

import com.example.tododevelopproject.auth.dto.LoginRequestDto;
import com.example.tododevelopproject.auth.dto.LoginResponseDto;
import com.example.tododevelopproject.common.config.PasswordEncoder;
import com.example.tododevelopproject.common.exception.InvalidPasswordException;
import com.example.tododevelopproject.common.exception.MemberNotFoundException;
import com.example.tododevelopproject.member.entity.Member;
import com.example.tododevelopproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    // 속성
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 생성자

    // 기능
    public LoginResponseDto login(LoginRequestDto requestDto) {

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        Member foundMember = memberRepository.findByEmail(email)
                .orElseThrow(() ->
                        new MemberNotFoundException("해당 이메일을 가진 회원이 없습니다."));

        if (!passwordEncoder.matches(password, foundMember.getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponseDto(foundMember);
    }
}
