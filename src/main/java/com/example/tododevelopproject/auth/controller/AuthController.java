package com.example.tododevelopproject.auth.controller;

import com.example.tododevelopproject.auth.dto.LoginRequestDto;
import com.example.tododevelopproject.auth.dto.LoginResponseDto;
import com.example.tododevelopproject.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    // 속성
    private final AuthService authService;

    // 생성자

    // 기능
    // ::: 로그인 기능 API
    @PostMapping("/session-login")
    public ResponseEntity<Void> login(
            @Valid @ModelAttribute LoginRequestDto requestDto,
            HttpServletRequest request
    ) {

        LoginResponseDto loginResponseDto = authService.login(requestDto);

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginResponseDto.getMember());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
