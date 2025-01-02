package com.example.tododevelopproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoNotFoundException extends ResponseStatusException {

    public TodoNotFoundException(String message) {

        super(HttpStatus.NOT_FOUND, message);
    }
}
