package com.example.lastproject.controller;

import com.example.lastproject.config.EndpointConfigurator;
import com.example.lastproject.service.ChatService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint(value = "/ws/chat/{courseId}", configurator = EndpointConfigurator.class)
public class MessageController{
    private ChatService chatService;
//    private static final List<Session> sessions = new CopyOnWriteArrayList<>();
    private static final Map<String, List<Session>> sessionsMap = new ConcurrentHashMap<>();

    public MessageController() {
    }

    @Autowired
    public MessageController(ChatService chatService) {
        this.chatService = chatService;
    }


    @OnOpen
    public void open(Session newUser, @PathParam("courseId") String courseId) {
        System.out.println("connected");
        sessionsMap.computeIfAbsent(courseId, k -> new CopyOnWriteArrayList<>()).add(newUser);
        System.out.println(newUser.getId());
    }

    @OnClose
    public void onClose(Session userSession, @PathParam("courseId") String courseId) {
        System.out.println("Disconnected: " + userSession.getId());
        sessionsMap.getOrDefault(courseId, Collections.emptyList()).remove(userSession);
    }

    @OnMessage
    public void getMsg(Session receiveSession, String msg, @PathParam("courseId") String courseId) throws IOException {

        JSONObject jsonMessage = new JSONObject(msg);
        String userName = jsonMessage.getString("userName");
        String content = jsonMessage.getString("content");
        Long userId = Long.valueOf(jsonMessage.getString("userId"));

        JSONObject newJsonObject = new JSONObject();
        newJsonObject.put("content", content);
        newJsonObject.put("userName", userName);
        newJsonObject.put("courseId", courseId);
        newJsonObject.put("createdAt", LocalDateTime.now());

        chatService.saveChatMessage(userId,Long.valueOf(courseId), content);
        System.out.println(userId);

        for (Session session : sessionsMap.getOrDefault(courseId, Collections.emptyList())) {
            if (session.isOpen()) {
                System.out.println(newJsonObject);
                session.getBasicRemote().sendText(String.valueOf(newJsonObject));
            }
        }
    }
}