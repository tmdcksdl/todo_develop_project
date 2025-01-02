package com.example.tododevelopproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidPasswordException extends ResponseStatusException {

    public InvalidPasswordException(String message) {

        super(HttpStatus.UNAUTHORIZED, message);
    }
}
