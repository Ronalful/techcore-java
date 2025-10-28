package com.example.task7To10.book;

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
    public ResponseEntity<BookDto> addBookWithStatus(@RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createBook(request));
    }

    @PutMapping("/books")
    public ResponseEntity<BookDto> updateBook(@RequestBody UpdateBookDto request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updateBook(request));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        service.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

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

    //Task 8
    @GetMapping("/books/test/incorrect")
    public ResponseEntity<List<BookDto>> getBooksIncorrect() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksIncorrect());
    }

    //Task 8
    @GetMapping("/books/test/correct")
    public ResponseEntity<List<BookDto>> getBooksCorrect() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksCorrect());
    }

    //Task 9
    @GetMapping("/books/search/{searchText}")
    public ResponseEntity<List<BookDto>> getBooksBySearchText(@PathVariable String searchText) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksBySearchText(searchText));
    }

    //Task 10
    @PostMapping("/new/books")
    public ResponseEntity<BookDto> addBookWithAuthor(@RequestBody CreateBookDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createBookWithAuthor(request));
    }
}
