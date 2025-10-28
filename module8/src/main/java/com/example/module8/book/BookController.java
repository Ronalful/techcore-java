package com.example.module8.book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {
    private final BookService service;

    @PostMapping("/books")
    public ResponseEntity<BookDto> addBookWithStatus(@Valid @RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createBook(request));
    }

    @PutMapping("/books")
    public ResponseEntity<BookDto> updateBook(@RequestBody UpdateBookDto request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updateBook(request));
    }

    //Task 10
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        service.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Task 10
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findBookById(id));
    }

    @GetMapping("/books/author/{author}")
    public ResponseEntity<List<BookDto>> getBookByAuthor(@PathVariable String author) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findBookAuthor(author));
    }

    @GetMapping("/books/search")
    public ResponseEntity<BookDto> getBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findBookByTitleAndAuthor(title, author));
    }

    @GetMapping("/books/test/incorrect")
    public ResponseEntity<List<BookDto>> getBooksIncorrect() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksIncorrect());
    }

    @GetMapping("/books/test/correct")
    public ResponseEntity<List<BookDto>> getBooksCorrect() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksCorrect());
    }

    @GetMapping("/books/search/{searchText}")
    public ResponseEntity<List<BookDto>> getBooksBySearchText(@PathVariable String searchText) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksBySearchText(searchText));
    }

    @PostMapping("/new/books")
    public ResponseEntity<BookDto> addBookWithAuthor(@Valid @RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createBookWithAuthor(request));
    }

    @GetMapping("/books/paging")
    public ResponseEntity<Page<BookDto>> getBooks(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks(pageable));
    }
}
