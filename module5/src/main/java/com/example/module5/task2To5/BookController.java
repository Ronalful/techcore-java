package com.example.module5.task2To5;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
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

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        System.out.printf("Была получена книга с названием: %s, и годом издания: %s%n", book.getTitle(), book.getYear());
        return book;
    }
}
