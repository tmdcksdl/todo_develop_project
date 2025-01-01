package com.example.tododevelopproject.comment.controller;

import com.example.tododevelopproject.comment.dto.UpdateCommentRequestDto;
import com.example.tododevelopproject.comment.dto.CommentResponseDto;
import com.example.tododevelopproject.comment.dto.CreateCommentRequestDto;
import com.example.tododevelopproject.comment.dto.CreateCommentResponseDto;
import com.example.tododevelopproject.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    // 속성
    private final CommentService commentService;

    // 생성자

    // 기능
    // ::: 댓글 생성 API
    @PostMapping
    public ResponseEntity<CreateCommentResponseDto> saveCommentAPI(@Valid @RequestBody CreateCommentRequestDto requestDto) {

        CreateCommentResponseDto createCommentResponseDto = commentService.saveComment(
                requestDto.getContents(),
                requestDto.getMemberId(),
                requestDto.getTodoId()
        );

        return new ResponseEntity<>(createCommentResponseDto, HttpStatus.CREATED);
    }

    // ::: 전체 댓글 조회 API
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> findAllAPI() {

        List<CommentResponseDto> commentResponseDtoList = commentService.findAll();

        return new ResponseEntity<>(commentResponseDtoList, HttpStatus.OK);
    }

    // ::: 선택 일정의 댓글 조회 API
    @GetMapping("/{todoId}")
    public ResponseEntity<List<CommentResponseDto>> findByTodoIdAPI(@PathVariable Long todoId) {

        List<CommentResponseDto> commentResponseDtoList = commentService.findByTodoId(todoId);

        return new ResponseEntity<>(commentResponseDtoList, HttpStatus.OK);
    }

    // ::: 선택 댓글 수정 API
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCommentAPI(
            @PathVariable Long id,
            @RequestParam String password,
            @RequestBody UpdateCommentRequestDto requestDto
            ){

        commentService.updateComment(id, password, requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ::: 선택 댓글 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentAPI(
            @PathVariable Long id,
            @RequestParam String password
    ) {

        commentService.deleteComment(id, password);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
