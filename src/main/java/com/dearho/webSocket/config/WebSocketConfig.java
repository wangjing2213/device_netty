package com.dearho.webSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
* @Author ruiwu
* @Description websocket 配置类
 * @Param
* @Data 2017-12-14 16:24
*/
@Configuration
@EnableWebSocketMessageBroker  //开启使用 STOMP 协议来传输基于代理（message broker）的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 注册 STOMP 协议的节点来映射指定的 URL 并指定使用 SocketJS 协议。
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointWeb").withSockJS();;
    }

    /**
     * 来配置一个广播式消息代理。
     * @param messageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        messageBrokerRegistry.enableSimpleBroker("/topic");
    }
}
