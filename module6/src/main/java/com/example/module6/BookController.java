package com.example.module6;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @PostMapping("/books")
    public ResponseEntity<Book> addBookWithStatus(@RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createBook(request));
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody UpdateBookDto request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updateBook(request));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        service.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBookById() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findBookById(id));
    }
}
