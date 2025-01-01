package com.example.tododevelopproject.auth.service;

import com.example.tododevelopproject.member.entity.Member;
import com.example.tododevelopproject.member.repository.MemberRepository;
import com.example.tododevelopproject.auth.dto.LoginRequestDto;
import com.example.tododevelopproject.auth.dto.LoginResponseDto;
import com.example.tododevelopproject.common.config.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                        new ResponseStatusException(HttpStatus.UNAUTHORIZED, "해당 이메일을 가진 회원이 없습니다."));

        if (!passwordEncoder.matches(password, foundMember.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponseDto(foundMember);
    }
}
