package com.example.module11.author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthorController {
    private final AuthorService service;

    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> addBookWithStatus(@RequestBody CreateAuthorDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createAuthor(request));
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>> getBookById() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAuthors());
    }
}
