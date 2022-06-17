//package com.dh.alarmservice.controller;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//
//import com.dh.alarmservice.config.WebSocketSpringConfigurator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//
//@Component
//@ServerEndpoint(value = "/call/center",configurator = WebSocketSpringConfigurator.class)
//public class WebSocketController {
//    private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);
//
//
//    @OnOpen
//    public void onOpen(Session session) {
//        log.info("onOpen:" + session.getId());
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        log.info("onClose:" + session.getId());
//    }
//
//    @OnMessage
//    public void onMessage(Session session, String message) {
//        log.info("onMessage:" + session.getId());
//        log.info("onMessage:" + message);
//    }
//
//    @OnError
//    public void onError(Session session, Throwable throwable) {
//        log.error("onError:" + session.getId());
//        log.error("onError:" + throwable.getMessage());
//    }
//
//
//}
