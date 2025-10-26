package com.example.module5.task2To9;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Задание 7
    @PostMapping("/task7/books")
    public ResponseEntity<Book> addBookWithStatus(@RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createBook(request));
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.updateBook(request));
    }

    @PatchMapping("/books")
    public ResponseEntity<Book> patchBook(@RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.patchBook(request));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable int id) {
        service.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
