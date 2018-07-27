package com.dearho.webSocket.model;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:服务端像向浏览器端发送消息实体类
 */
public class ServerResponseMessage {
    private String responseMessage;
    public ServerResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}