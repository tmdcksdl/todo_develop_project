package com.example.tododevelopproject.Lv1.repository;

import com.example.tododevelopproject.Lv1.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
