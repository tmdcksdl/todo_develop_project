package com.example.tododevelopproject.comment.repository;

import com.example.tododevelopproject.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 id와 일치하는 댓글이 없습니다."));
    }

    List<Comment> findByTodoId(Long todoId);
}
