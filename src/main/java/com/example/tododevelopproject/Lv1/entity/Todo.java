package com.example.tododevelopproject.Lv1.entity;


import jakarta.persistence.*;

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


    // 기능
}
