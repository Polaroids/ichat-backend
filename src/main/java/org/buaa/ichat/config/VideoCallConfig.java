package org.buaa.ichat.config;

import org.kurento.client.KurentoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoCallConfig {

    @Bean
    public KurentoClient kurentoClient() {
        return KurentoClient.create();
    }
}
