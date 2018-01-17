package com.challenge.webchat.controller.rest.response;


public enum ResponseType {

    SUCCESS,
    WARNING,
    DANGER,
    INFO;

    public String toString() {
        return super.toString().toLowerCase();
    }
}
