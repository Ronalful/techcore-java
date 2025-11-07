package com.example.notification.kafka;

public record BookCreatedEvent(
        Long id,
        String title,
        Integer publicationYear
) {
}
