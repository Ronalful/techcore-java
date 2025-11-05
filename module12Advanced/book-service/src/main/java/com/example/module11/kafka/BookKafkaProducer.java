package com.example.module11.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookKafkaProducer {
    private final KafkaTemplate<String, BookCreatedEvent> kafkaTemplate;
    private static final String TOPIC = "book_events";

    public void sendBookCreatedEvent(BookCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
