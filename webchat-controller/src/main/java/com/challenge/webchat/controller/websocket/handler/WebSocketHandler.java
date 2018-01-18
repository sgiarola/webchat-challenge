package com.challenge.webchat.controller.websocket.handler;

import com.challenge.webchat.controller.websocket.dto.ChatDTO;
import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOGGER = LogManager.getLogger(WebSocketHandler.class);

    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {

        ChatDTO chatDTO = new Gson().fromJson(message.getPayload(), ChatDTO.class);
        LOGGER.info(String.format("Received message %s. Chat between %s.",
                message.getPayload(), chatDTO.getMessage().getChatGroup()));

        for(WebSocketSession webSocketSession : sessions) {
            if (webSocketSession.isOpen()) {
                LOGGER.info(String.format("Send message to %s", webSocketSession.getId()));
                webSocketSession.sendMessage(new TextMessage(new Gson().toJson(chatDTO)));
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }
}
