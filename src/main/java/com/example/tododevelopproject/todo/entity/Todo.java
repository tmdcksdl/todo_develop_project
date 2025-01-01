package com.example.tododevelopproject.todo.entity;

import com.example.tododevelopproject.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseTodoEntity {

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 생성자
    public Todo() {}

    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    // 기능
    public void setMember(Member member) {
        this.member = member;
    }


    public void updateTodo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}