package com.jwt.authentication.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find User of id: " + id);
    }
}
