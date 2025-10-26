package com.example.module5.task2To6;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/book")
    public Book book() {
        return new Book("Peace and War", 1867);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        System.out.println("Id книги: " + id);
        return new Book("Crime and Punishment", 1866);
    }

    @GetMapping("/books/search")
    public Book getBookById(@RequestParam(required = false) String title) {
        System.out.println("Параметр title: " + title);
        return new Book("War and Peace", 1867);
    }

    // Задание 5
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        System.out.printf("Была получена книга с названием: %s, и годом издания: %s%n", book.getTitle(), book.getYear());
        return book;
    }

    // Задание 6
    @PostMapping("/task6/books")
    public Book addBook(@RequestBody CreateBookDto request) {
        return service.createBook(request);
    }
}
