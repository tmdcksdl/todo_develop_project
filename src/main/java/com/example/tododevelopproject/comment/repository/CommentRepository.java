package com.example.tododevelopproject.comment.repository;

import com.example.tododevelopproject.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTodoId(Long todoId);
}
