package com.example.module7.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApiService service;


    //Task 7
    @GetMapping("/api/{query}")
    public ResponseEntity<ApiDto> restTemplateRequest(@PathVariable String query) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.restTemplateRequest(query));
    }
}
