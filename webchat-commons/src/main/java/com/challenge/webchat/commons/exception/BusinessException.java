package com.challenge.webchat.commons.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String description) {
        super(description);
    }
}
