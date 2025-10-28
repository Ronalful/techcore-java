package com.example.module7.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiService {
    private static final String API_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private final RestTemplate restTemplate;

    //Task 7
    public ApiDto restTemplateRequest(String query) {
        return restTemplate.getForObject(API_URL + query, ApiDto.class);
    }
}
