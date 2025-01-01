package com.example.tododevelopproject.comment.entity;

import com.example.tododevelopproject.todo.entity.Todo;
import com.example.tododevelopproject.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends BaseCommentEntity{

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    // 생성자
    public Comment(String contents) {
        this.contents = contents;
    }

    // 기능
    public void setMember(Member member){
        this.member = member;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
