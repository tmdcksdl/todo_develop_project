package com.example.tododevelopproject.comment.service;

import com.example.tododevelopproject.comment.dto.CommentResponseDto;
import com.example.tododevelopproject.comment.dto.CreateCommentResponseDto;
import com.example.tododevelopproject.comment.entity.Comment;
import com.example.tododevelopproject.comment.repository.CommentRepository;
import com.example.tododevelopproject.common.config.PasswordEncoder;
import com.example.tododevelopproject.common.exception.CommentNotFoundException;
import com.example.tododevelopproject.common.exception.InvalidPasswordException;
import com.example.tododevelopproject.common.exception.MemberNotFoundException;
import com.example.tododevelopproject.common.exception.TodoNotFoundException;
import com.example.tododevelopproject.member.dto.MemberResponseDto;
import com.example.tododevelopproject.member.entity.Member;
import com.example.tododevelopproject.member.repository.MemberRepository;
import com.example.tododevelopproject.todo.dto.TodoResponseDto;
import com.example.tododevelopproject.todo.entity.Todo;
import com.example.tododevelopproject.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        Member foundMember = memberRepository.findById(memberId).orElseThrow(() ->
                new MemberNotFoundException("해당 Id를 가진 회원이 존재하지 않습니다."));
        Todo foundTodo = todoRepository.findById(todoId).orElseThrow(() ->
                new TodoNotFoundException("해당 Id를 가진 일정이 존재하지 않습니다."));

        Comment comment = new Comment(contents, foundMember, foundTodo);

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
            throw new CommentNotFoundException("해당 Id에 대한 댓글이 없습니다.");
        }

        return comments.stream()
                .map(CommentResponseDto::commentDto)
                .toList();
    }

    @Transactional
    public void updateComment(Long id, String password, String contents) {

        Comment foundComment = commentRepository.findById(id).orElseThrow(() ->
                new CommentNotFoundException("해당 Id에 대한 댓글이 없습니다."));

        if (!passwordEncoder.matches(password, foundComment.getMember().getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }

        foundComment.update(contents);
    }

    public void deleteComment(Long id, String password) {

        Comment foundComment = commentRepository.findById(id).orElseThrow(() ->
                new CommentNotFoundException("해당 Id에 대한 댓글이 없습니다."));

        if (!passwordEncoder.matches(password, foundComment.getMember().getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }

        commentRepository.delete(foundComment);
    }
}
