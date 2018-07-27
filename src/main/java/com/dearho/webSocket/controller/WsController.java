package com.dearho.webSocket.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.dearho.webSocket.model.Message;
import com.dearho.webSocket.model.ServerResponseMessage;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:请求控制器
 */
@Controller
public class WsController {
    /**
     * @Description 通过 @MessageMapping 注解接收浏览器端发送的消息。
     *                通过 @SendTo 注解像浏览器端广播消息。
     * @param message
     * @return
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ServerResponseMessage say(Message message) {
        System.out.println(">>>>>>>>>>>>>> " + message.getName());
        return new ServerResponseMessage("Welcome," + message.getName() + "!");
    }
}
