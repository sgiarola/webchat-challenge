package com.challenge.webchat.controller.websocket.dto;

public class ChatDTO {

    private MessageDTO message;

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }
}
