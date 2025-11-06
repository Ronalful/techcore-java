package com.example.notification.kafka;

import com.example.notification.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookKafkaListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "book_events", groupId = "notification-service")
    public void listen(BookCreatedEvent event) {
        System.out.println("Книга создана с названием: " + event.title());

        notificationService.createNotification(event);
    }
}
