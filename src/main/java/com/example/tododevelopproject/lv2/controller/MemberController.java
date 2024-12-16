package com.example.tododevelopproject.lv2.controller;

import com.example.tododevelopproject.lv2.dto.MemberRequestDto;
import com.example.tododevelopproject.lv2.dto.MemberResponseDto;
import com.example.tododevelopproject.lv2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    // 속성
    private final MemberService memberService;

    // 생성자

    // 기능
    // ::: 회원 생성 API
    @PostMapping
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberRequestDto requestDto) {

        MemberResponseDto memberResponseDto = memberService.saveMember(
                requestDto.getUsername(),
                requestDto.getEmail()
        );

        return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
    }


}
