package com.jaystar.eatgo.domain;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
