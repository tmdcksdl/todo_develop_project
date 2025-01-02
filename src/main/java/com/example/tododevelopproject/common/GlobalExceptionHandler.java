package com.example.tododevelopproject.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ResponseStatusException 예외 처리
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionResponseDto> handleCustomException(ResponseStatusException exception) {

        ExceptionResponseDto response = new ExceptionResponseDto(
                exception.getStatusCode().toString(),  // 에러 코드: HTTP 상태 코드
                exception.getReason()  // 에러 메시지
        );

        return ResponseEntity
                .status(exception.getStatusCode())
                .body(response);
    }

    // DTO 유효성 검사 실패 (MethodArgumentNotValidException)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        String errorMessage = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse("유효성 검사를 실패했습니다.");

        ExceptionResponseDto response = new ExceptionResponseDto(
                exception.getStatusCode().toString(),
                errorMessage
        );

        return  ResponseEntity
                .status(exception.getStatusCode())
                .body(response);
    }
}
