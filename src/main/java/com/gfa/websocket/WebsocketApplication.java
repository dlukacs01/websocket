package com.gfa.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketApplication {

    // https://spring.io/guides/gs/messaging-stomp-websocket/
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

}
