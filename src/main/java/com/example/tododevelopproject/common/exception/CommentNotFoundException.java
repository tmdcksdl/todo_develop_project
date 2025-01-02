package com.example.tododevelopproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommentNotFoundException extends ResponseStatusException {

    public CommentNotFoundException(String message) {

        super(HttpStatus.NOT_FOUND, message);
    }
}
