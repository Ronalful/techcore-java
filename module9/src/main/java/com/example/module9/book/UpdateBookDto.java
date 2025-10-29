package com.example.module9.book;

public record UpdateBookDto(Long id, String title, Integer publicationYear, String author) {
}