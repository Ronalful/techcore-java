package com.example.module11.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic bookCreatedTopic() {
        return new NewTopic("book_events", 4, (short) 1);
    }

    @Bean
    public NewTopic bookEventsDLQ() {
        return new NewTopic("book_events_dlq", 1, (short) 1);
    }
}
