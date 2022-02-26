package com.jaystar.eatgo.application;

public class EmailNotExistsException extends RuntimeException {
    public EmailNotExistsException(String email) {
        super("Email is not registered: " + email);
    }
}
