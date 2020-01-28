package org.easymis.easysaas.portal.websocket.v1;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 * websocket服务端
 */
@Component
@ServerEndpoint(value = "/myWebSocket")
public class MyWebSocket {

    //用来存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<MyWebSocket> user = new CopyOnWriteArraySet<MyWebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {

        //群发消息
        for (MyWebSocket myWebSocket : user) {
            myWebSocket.session.getBasicRemote().sendText(session.getId()+"说："+message);
            //myWebSocket.session.getBasicRemote().sendText("<img src=''/>");
        }
    }

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId()+" open...");
        this.session = session;
        user.add(this);
    }
    @OnClose
    public void onClose(){
        System.out.println(this.session.getId()+" close...");
        user.remove(this);
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println(this.session.getId()+" error...");
        error.printStackTrace();
    }

}