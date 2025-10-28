package com.example.module7.async;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//Task 5
@RestController
@RequiredArgsConstructor
public class AsyncController {
    private final AsyncService service;

    @PostMapping("/async")
    public ResponseEntity<Void> async() {
        service.doSomething();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
