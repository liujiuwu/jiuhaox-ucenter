package com.jiuhaox.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.jiuhaox.ucenter.adapter.outbound.repository")
public class AppServer {
    public static void main(String[] args) {
        SpringApplication.run(AppServer.class, args);
    }

    @Bean
    @Profile("!prod")
    public LoggingEventListener mongoEventListener() {
        return new LoggingEventListener();
    }
}
