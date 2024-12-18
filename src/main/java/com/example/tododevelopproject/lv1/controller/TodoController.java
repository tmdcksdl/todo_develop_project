package com.example.tododevelopproject.lv1.controller;

import com.example.tododevelopproject.lv1.dto.TodoRequestDto;
import com.example.tododevelopproject.lv1.dto.TodoResponseDto;
import com.example.tododevelopproject.lv1.dto.UpdateRequestDto;
import com.example.tododevelopproject.lv1.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    // 속성
    private final TodoService todoService;

    // 생성자


    // 기능
    // ::: 일정 생성 API
    @PostMapping
    public ResponseEntity<TodoResponseDto> saveTodo(@Valid @RequestBody TodoRequestDto requestDto) {

        TodoResponseDto todoResponseDto = todoService.saveTodo(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getMemberId()
        );

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    // ::: 전체 일정 조회 API
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll() {

        List<TodoResponseDto> todoResponseDtoList = todoService.findAll();

        return new ResponseEntity<>(todoResponseDtoList, HttpStatus.OK);
    }

    // ::: 선택 일정 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findById(@PathVariable Long id) {

        TodoResponseDto todoResponseDto = todoService.findById(id);

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // ::: 선택 일정 수정 API
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody UpdateRequestDto requestDto
    ) {

        todoService.updateTodo(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ::: 선택 일정 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
