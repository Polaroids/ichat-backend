package org.buaa.ichat.config;

import org.buaa.ichat.video.VideoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoCallConfig {

    @Bean
    public VideoHandler videoHandler() {
        return new VideoHandler();
    }

//    @Bean
//    public OnlineUser onlineUser() {
//        return new OnlineUser();
//    }

//    @Bean
//    public KurentoClient kurentoClient() {
//        return KurentoClient.create();
//    }
}
