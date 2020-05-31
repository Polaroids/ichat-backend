package org.buaa.ichat;

import org.buaa.ichat.video.CallHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.kurento.client.KurentoClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@ComponentScan(basePackages = {"org.buaa.ichat.*"})
@MapperScan("org.buaa.ichat.mapper")
@SpringBootApplication
@EnableWebSocket
public class MainApplication implements WebSocketConfigurer {

    @Bean
    public CallHandler callHandler() {
        return new CallHandler();
    }

    @Bean
    public org.kurento.tutorial.one2onecall.UserRegistry registry() {
        return new org.kurento.tutorial.one2onecall.UserRegistry();
    }

    @Bean
    public KurentoClient kurentoClient() {
        return KurentoClient.create();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(callHandler(), "/call");
    }

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
