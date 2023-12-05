package com.example.lastproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/ws/chat/{courseId}")
public class MessageController extends Socket {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private static final List<Session> sessions = new ArrayList<>();
    public MessageController(){
    }
    @OnOpen
    public void open(Session newUser, @PathParam("courseId") String courseId) {
        System.out.println("Connected");
        sessions.add(newUser);
    }

    @OnMessage
    public void getMsg(@PathParam("courseId") String courseId, String msg) {
        // 채팅 메시지를 특정 주제로 전송
        messagingTemplate.convertAndSend("/topic/chat/" + courseId, msg);
    }

}
