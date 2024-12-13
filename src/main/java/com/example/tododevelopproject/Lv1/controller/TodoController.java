package com.example.tododevelopproject.Lv1.controller;

import com.example.tododevelopproject.Lv1.dto.TodoRequestDto;
import com.example.tododevelopproject.Lv1.dto.TodoResponseDto;
import com.example.tododevelopproject.Lv1.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    // 속성
    private final TodoService todoService;

    // 생성자

    // 기능
    @PostMapping
    public ResponseEntity<TodoResponseDto> saveTodo(@RequestBody TodoRequestDto requestDto) {

        TodoResponseDto todoResponseDto = todoService.saveTodo(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }
}
