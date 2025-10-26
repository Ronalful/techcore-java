package com.example.module5.task2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/book")
    public Book book() {
        return new Book("Peace and War", 1867);
    }
}
