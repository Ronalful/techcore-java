package com.example.module8.book;

public record UpdateBookDto(Long id, String title, Integer publicationYear, String author) {
}