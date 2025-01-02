package com.example.tododevelopproject.todo.repository;

import com.example.tododevelopproject.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
