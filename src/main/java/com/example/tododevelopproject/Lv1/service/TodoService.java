package com.example.tododevelopproject.Lv1.service;

import com.example.tododevelopproject.Lv1.dto.TodoResponseDto;
import com.example.tododevelopproject.Lv1.entity.Todo;
import com.example.tododevelopproject.Lv1.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    // 속성
    private final TodoRepository todoRepository;

    // 생성자

    // 기능
    public TodoResponseDto saveTodo(String username, String title, String contents) {

        Todo todo = new Todo(username, title, contents);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoResponseDto(savedTodo.getId(), savedTodo.getUsername(), savedTodo.getTitle(), savedTodo.getContents());
    }
}