package com.example.tododevelopproject.lv2lv3.controller;

import com.example.tododevelopproject.lv2lv3.dto.MemberRequestDto;
import com.example.tododevelopproject.lv2lv3.dto.MemberResponseDto;
import com.example.tododevelopproject.lv2lv3.dto.UpdateReqeustDto;
import com.example.tododevelopproject.lv2lv3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
    }

    // ::: 전체 회원 조회 API
     @GetMapping
     public ResponseEntity<List<MemberResponseDto>> findAll() {

        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();

        return new ResponseEntity<>(memberResponseDtoList, HttpStatus.OK);
    }

    // ::: 선택 회원 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    // ::: 선택 회원 수정 API
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long id,
            @RequestBody UpdateReqeustDto requestDto,
            @RequestParam String password
    ) {

        memberService.updateMember(id, requestDto.getEmail(), password);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ::: 선택 회원 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable Long id,
            @RequestParam String password
    ) {

        memberService.deleteMember(id, password);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
