package com.challenge.webchat.controller.websocket.dto;

import com.google.common.collect.Lists;

import java.util.List;

public class MessageDTO {

    private String content;
    private String sender;
    private List<String> chatGroup;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(List<String> chatGroup) {
        this.chatGroup = chatGroup;
    }

    public List<String> getReceivers() {
        List<String> receivers = Lists.newArrayList(chatGroup);
        receivers.removeIf(sender -> chatGroup.contains(sender));
        return receivers;
    }
}
