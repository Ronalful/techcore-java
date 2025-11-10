package com.example.notification.notification;

import com.example.notification.kafka.BookCreatedEvent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    private String id;
    private BookCreatedEvent bookCreatedEvent;
}
