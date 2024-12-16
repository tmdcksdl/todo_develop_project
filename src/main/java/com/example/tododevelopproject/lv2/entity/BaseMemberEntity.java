package com.example.tododevelopproject.lv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseMemberEntity {

    // 속성
    @CreatedDate
    @Column(nullable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    // 생성자


    // 기능
}
