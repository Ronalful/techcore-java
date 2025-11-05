package com.example.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookKafkaListener {

    @KafkaListener(topics = "book_events", groupId = "notification-service")
    public void listen(BookCreatedEvent event) {
        System.out.println("Книга создана с названием: " + event.title());
    }
}
