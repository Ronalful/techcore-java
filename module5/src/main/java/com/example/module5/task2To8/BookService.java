package com.example.module5.task2To8;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book createBook(CreateBookDto request) {
        Book book = new Book(request.title(), request.year());
        System.out.printf("Была получена книга с названием: %s, и годом издания: %s%n", book.getTitle(), book.getYear());
        return book;
    }

    public Book updateBook(CreateBookDto request) {
        Book book = new Book(request.title(), request.year());
        System.out.printf("Была обновлена книга на книгу с названием: %s, и годом издания: %s%n", book.getTitle(), book.getYear());
        return new Book(request.title(), request.year());
    }

    public Book patchBook(CreateBookDto request) {
        Book book = new Book();
        if (request.title() != null) {
            System.out.println("Название книги было обновлено: " + request.title());
            book.setTitle(request.title());
        }
        if (request.year() != null) {
            System.out.println("Год издания книги был обновлен: " + request.year());
            book.setYear(request.year());
        }
        return book;
    }
}
