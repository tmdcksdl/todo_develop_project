package com.example.tododevelopproject.todo.service;

import com.example.tododevelopproject.common.exception.MemberNotFoundException;
import com.example.tododevelopproject.common.exception.TodoNotFoundException;
import com.example.tododevelopproject.todo.dto.TodoResponseDto;
import com.example.tododevelopproject.todo.entity.Todo;
import com.example.tododevelopproject.todo.repository.TodoRepository;
import com.example.tododevelopproject.member.dto.MemberResponseDto;
import com.example.tododevelopproject.member.entity.Member;
import com.example.tododevelopproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    // 속성
    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    // 생성자

    // 기능
    // ::: 일정 생성 서비스
    public TodoResponseDto saveTodo(String title, String contents, Long memberId) {

        Member foundMember = memberRepository.findById(memberId).orElseThrow(() ->
                new MemberNotFoundException("해당 Id를 가진 회원이 존재하지 않습니다."));

        Todo todo = new Todo(title, contents, foundMember);

        Todo savedTodo = todoRepository.save(todo);

        MemberResponseDto memberResponseDto = new MemberResponseDto(savedTodo.getMember().getId(), savedTodo.getMember().getUsername(), savedTodo.getMember().getEmail());

        return new TodoResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents(), memberResponseDto);
    }

    // ::: 전체 일정 조회 서비스
    public List<TodoResponseDto> findAll() {

        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDto::toDo)
                .toList();
    }

    // ::: 선택 일정 조회 서비스
    public TodoResponseDto findById(Long id) {

        Todo foundTodo = todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException("해당 Id를 가진 일정이 존재하지 않습니다."));

        MemberResponseDto memberResponseDto = new MemberResponseDto(
                foundTodo.getMember().getId(),
                foundTodo.getMember().getUsername(),
                foundTodo.getMember().getEmail()
        );

        return new TodoResponseDto(foundTodo.getId(), foundTodo.getTitle(), foundTodo.getContents(), memberResponseDto);
    }

    // ::: 선택 일정 수정 서비스
    @Transactional
    public void updateTodo(Long id, String title, String contents) {

        Todo foundTodo = todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException("해당 Id를 가진 일정이 존재하지 않습니다."));

        foundTodo.updateTodo(title, contents);
    }

    // ::: 선택 일정 삭제 서비스
    public void deleteTodo(Long id) {

        Todo foundTodo = todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException("해당 Id를 가진 일정이 존재하지 않습니다."));

        todoRepository.delete(foundTodo);
    }
}
