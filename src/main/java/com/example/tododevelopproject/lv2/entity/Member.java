package com.example.tododevelopproject.lv2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member extends BaseMemberEntity{

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Email
    private String email;

    // 생성자
    public Member(String username, String email) {
        this.username = username;
        this.email = email;
    }


    // 기능
    public void update(String email) {
        this.email = email;
    }
}
