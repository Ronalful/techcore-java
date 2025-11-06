package com.example.notification.notification;

import com.example.notification.kafka.BookCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;


    public void createNotification(BookCreatedEvent event) {
        notificationRepository.save(Notification.builder()
                        .bookCreatedEvent(event)
                        .build());
    }
}
