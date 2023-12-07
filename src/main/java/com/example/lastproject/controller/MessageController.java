package com.example.lastproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@ServerEndpoint("/ws/chat/{courseId}")
public class MessageController {
    private final SimpMessagingTemplate messagingTemplate;
    private static final List<Session> sessions = new CopyOnWriteArrayList<>();
    public MessageController() {
        this.messagingTemplate = null; // 또는 null이 아닌 기본 값을 설정해 주세요.
    }
    @Autowired
    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        sessions.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnClose
    public void onClose(Session userSession) {
        System.out.println("Disconnected: " + userSession.getId());
        sessions.remove(userSession);
    }

    @OnMessage
    public void getMsg(Session receiveSession, String msg, @PathParam("courseId") String courseId) throws IOException {
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(msg);
            }
        }
    }
}