package com.dh.alarmservice.controller;

import com.dh.alarmservice.config.WebSocketSpringConfigurator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@ServerEndpoint(value = "/call/center/{userId}",configurator = WebSocketSpringConfigurator.class)
public class WebSocketServer {
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    private static int onlineCount = 0;     // 统计在线人数，粗略统计，未涉及并发
    public static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();   // session管理map
    private Session session;    // 会话session
    private String userId="";   // 当前用户

    /**
     * 初始化连接
     *
     * @param session 会话session
     * @param userId 当前用户id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        log.info("onOpen:" + session.getId());
        this.session = session;
        this.userId=userId;

        // 保存各用户的会话session
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
        }else{
            webSocketMap.put(userId, this);
            addOnlineCount();
        }

        try {
            sendMessage("connect success");
        } catch (IOException e) {

        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        log.info("onClose:" + session.getId());
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            subOnlineCount();
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("onMessage:" + session.getId());
        log.info("onMessage:" + message);
    }

    /**
     * 异常处理
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("onError:" + session.getId());
        log.error("onError:" + error.getMessage());
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送自定义消息
     *
     * @param message 消息体
     * */
    public static void sendInfo(String message) throws IOException {

        List<String> keys = new ArrayList<>(webSocketMap.keySet());
        if (!StringUtils.isEmpty(keys)) {
            for (String key : keys) {
                webSocketMap.get(key).sendMessage(message);
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }


}
