package com.example.tododevelopproject.member.repository;

import com.example.tododevelopproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    Optional<Member> findByEmail(String email);
}