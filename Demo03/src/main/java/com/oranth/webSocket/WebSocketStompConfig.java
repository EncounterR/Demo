package com.oranth.webSocket;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket的配置
 * @author WU
 *
 */
@Configuration
@Component
public class WebSocketStompConfig {
	/**
	 * 使用spring boot时，使用的是spring-boot的内置容器，
	 * 如果要使用WebSocket，需要注入ServerEndpointExporter
     *
     * @return
     */
	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
		System.out.println("ServerEndpointExporter已经注入");
        return new ServerEndpointExporter();
    }
}
