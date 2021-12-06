package com.oxbey.footballManager.exception;

public class NotEnoughBudgetException extends RuntimeException{
    public NotEnoughBudgetException(String message) {
        super(message);
    }
}
