package com.example.module5.task2To6;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book createBook(CreateBookDto request) {
        Book book = new Book(request.title(), request.year());
        System.out.printf("Была получена книга с названием: %s, и годом издания: %s%n", book.getTitle(), book.getYear());
        return book;
    }
}
