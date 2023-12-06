package com.example.lastproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@ServerEndpoint("/ws/chat/{courseId}")
public class MessageController {
    private final SimpMessagingTemplate messagingTemplate;
    private static final List<Session> sessions = new ArrayList<>();

    @Autowired
    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @OnOpen
    public void open(Session newUser, @PathParam("courseId") String courseId) {
        System.out.println("connected");
        sessions.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnMessage
    public void getMsg(Session receiveSession, String msg, @PathParam("courseId") String courseId) throws IOException {
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(courseId +" : "+ msg);
            }
        }
    }
}