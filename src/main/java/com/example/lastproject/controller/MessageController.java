package com.example.lastproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.net.Socket;


// 실시간이지만 로그를 남겨둘꺼임 채팅을 누가 하고있으면 ?
// 내역이 떠야하잖아 네네 그럼 디비에서 불러서 가져와야하잖아
// 아아 뭔말알 그냥 find()해서 쳇내역을 누가 보냈는지 createAT을 비교해서 우르르 만들어야한다 맞?
// 그럼 우리가 채팅방을 보고있을떄 로그인 되어있는지? 근데 우리가 로그인을 하면 소켓을 연결하잖아요?
// 그럼 이것도 중간중간에 확인해야함?

// 두개를 한번에 못함? 소켓통신을 하고있는데 API통신요청을 보내는건 이상한짓?
// 다 긁어와야하니까..ㅠ 난 로그인할때 소켓을 연결하니까 -> 그럼 채팅방에 들어갈때 채팅방에 내역들을 다 가져올려면 API통신을 해야함
// 그럼 소켓연결되어있는 상태에서 API통신을 요청한다? 그럼 이렇게하면됨? 그럼 리액트에서 컴포넌트별로 소켓 연결하면되겠다.
// 그럼 연결전에 API로 다 받아오고 연결하면 끝 싹다 프론트


@Controller
@ServerEndpoint("/websocket")
public class MessageController extends Socket {
    public MessageController(){
    }
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
    @OnOpen
    public void open(Session newUser){
        System.out.println("connected");
    }

//    @OnMessage
//    public void getMsg(Session recieveSession, String msg) {
//        for (int i = 0; i < session.size(); i++) {
//            if (!recieveSession.getId().equals(session.get(i).getId())) {
//                try {
//                    session.get(i).getBasicRemote().sendText("상대 : " + msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                try {
//                    session.get(i).getBasicRemote().sendText("나 :" + msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
