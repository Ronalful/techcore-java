package com.example.module11.kafka;

public record BookCreatedEvent(
        Long id,
        String title,
        Integer publicationYear
) {
}
