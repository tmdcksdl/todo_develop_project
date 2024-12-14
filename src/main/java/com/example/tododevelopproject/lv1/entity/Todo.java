package com.example.tododevelopproject.lv1.entity;

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
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    // 생성자
    public Todo() {}

    public Todo(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }


    // 기능
    public void updateTodo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
