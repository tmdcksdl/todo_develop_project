package com.example.tododevelopproject.lv1.service;

import com.example.tododevelopproject.lv1.dto.TodoResponseDto;
import com.example.tododevelopproject.lv1.entity.Todo;
import com.example.tododevelopproject.lv1.repository.TodoRepository;
import com.example.tododevelopproject.lv2.entity.Member;
import com.example.tododevelopproject.lv2.repository.MemberRepository;
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

        Member findMember = memberRepository.findByIdOrElseThrow(memberId);

        Todo todo = new Todo(title, contents);
        todo.setMember(findMember);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());
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

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        return new TodoResponseDto(findTodo.getId(), findTodo.getTitle(), findTodo.getContents());
    }

    // ::: 선택 일정 수정 서비스
    @Transactional
    public void updateTodo(Long id, String title, String contents) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        findTodo.updateTodo(title, contents);
    }

    // ::: 선택 일정 삭제 서비스
    public void deleteTodo(Long id) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        todoRepository.delete(findTodo);
    }
}
