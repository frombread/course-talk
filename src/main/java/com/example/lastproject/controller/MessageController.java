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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint(value = "/ws/chat/{courseId}", configurator = EndpointConfigurator.class)
public class MessageController{
    private ChatService chatService;
    private static final List<Session> sessions = new CopyOnWriteArrayList<>();

    public MessageController() {
        // 기본 생성자 내용 추가 (필요한 경우)
    }
    @Autowired
    public MessageController(ChatService chatService) {
        this.chatService = chatService;
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

        for (Session session : sessions) {
            if (session.isOpen()) {
                System.out.println(newJsonObject);
                session.getBasicRemote().sendText(String.valueOf(newJsonObject));
            }
        }
    }
}