package com.example.tododevelopproject.comment.service;

import com.example.tododevelopproject.todo.dto.TodoResponseDto;
import com.example.tododevelopproject.todo.entity.Todo;
import com.example.tododevelopproject.todo.repository.TodoRepository;
import com.example.tododevelopproject.member.dto.MemberResponseDto;
import com.example.tododevelopproject.member.entity.Member;
import com.example.tododevelopproject.member.repository.MemberRepository;
import com.example.tododevelopproject.common.config.PasswordEncoder;
import com.example.tododevelopproject.comment.dto.CommentResponseDto;
import com.example.tododevelopproject.comment.dto.CreateCommentResponseDto;
import com.example.tododevelopproject.comment.entity.Comment;
import com.example.tododevelopproject.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    // 속성
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 생성자

    // 기능
    public CreateCommentResponseDto saveComment(String contents, Long memberId, Long todoId) {

        Member foundMember = memberRepository.findByIdOrElseThrow(memberId);
        Todo foundTodo = todoRepository.findByIdOrElseThrow(todoId);

        Comment comment = new Comment(contents);
        comment.setMember(foundMember);
        comment.setTodo(foundTodo);

        Comment savedComment = commentRepository.save(comment);

        MemberResponseDto memberResponseDto = new MemberResponseDto(savedComment.getMember().getId(), savedComment.getMember().getUsername(), savedComment.getMember().getEmail());
        TodoResponseDto todoResponseDto = new TodoResponseDto(savedComment.getTodo().getId(), savedComment.getTodo().getTitle(), savedComment.getTodo().getContents(), memberResponseDto);

        return new CreateCommentResponseDto(savedComment.getId(),savedComment.getContents(), todoResponseDto);
    }

    public List<CommentResponseDto> findAll() {

        return commentRepository.findAll()
                .stream()
                .map(CommentResponseDto::commentDto)
                .toList();
    }

    public List<CommentResponseDto> findByTodoId(Long todoId) {

        List<Comment> comments = commentRepository.findByTodoId(todoId);

        if(comments.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 일정에 대한 댓글이 없습니다.");
        }

        return comments.stream()
                .map(CommentResponseDto::commentDto)
                .toList();
    }

    @Transactional
    public void updateComment(Long id, String password, String contents) {

        Comment foundComment = commentRepository.findByIdOrElseThrow(id);

        if (passwordEncoder.matches(password, foundComment.getMember().getPassword())) {
            foundComment.update(contents);
        }
    }

    public void deleteComment(Long id, String password) {

        Comment foundComment = commentRepository.findByIdOrElseThrow(id);

        if (passwordEncoder.matches(password, foundComment.getMember().getPassword())) {
            commentRepository.delete(foundComment);
        }
    }
}
