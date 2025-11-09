package com.example.gateway.fallback;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
@RequiredArgsConstructor
public class FallbackController {

    @RequestMapping("/books")
    public ResponseEntity<Map<String, String>> fallback() {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Book service is unavailable");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
}
