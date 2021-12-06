package com.oxbey.footballManager.exception;

public class ClubNotFoundException extends RuntimeException{
    public ClubNotFoundException(String message) {
        super(message);
    }
}
