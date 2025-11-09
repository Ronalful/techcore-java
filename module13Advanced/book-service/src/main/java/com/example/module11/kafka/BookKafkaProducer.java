package com.example.module11.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookKafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "book_events";

    public void sendBookCreatedEvent(BookCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event.id().toString(), event);
    }

    public void sendBrokenMessage() {
        kafkaTemplate.send(TOPIC, "123", "this_is_not_a_valid_json");
    }
}
