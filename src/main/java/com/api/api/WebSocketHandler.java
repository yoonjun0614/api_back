package com.api.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class WebSocketHandler  extends TextWebSocketHandler {

    private static List<WebSocketSession> list = new ArrayList<>();
    private Session clients;

    private static WebSocketHandler thisObj = null;
    private static boolean boolAlready_init = false;

    public WebSocketHandler() {
        super();
    }

    public synchronized static WebSocketHandler getInstance(){
        if ( thisObj == null ){
            try {
                thisObj = new WebSocketHandler();
                if(boolAlready_init == false)
                    thisObj.init();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return thisObj;
    }

    private void init()
    {
        boolAlready_init = true;
    }

    public synchronized void sendToClientMessage(String message) throws Exception
    {
        for(WebSocketSession sess: list) {
            sess.sendMessage(new TextMessage(message));
        }
    }

    @Override
    protected synchronized void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for(WebSocketSession sess: list) {
            sess.sendMessage(message);
        }
    }

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public synchronized void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info(session + " 클라이언트 접속");
    }

    /* Client가 접속 해제 시 호출되는 메서드드 */
    @Override
    public synchronized void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해제");
        list.remove(session);

    }
}
