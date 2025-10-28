package com.example.module7.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiService {
    private static final String API_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    //Task 7
    public ApiDto restTemplateRequest(String query) {
        return restTemplate.getForObject(API_URL + query, ApiDto.class);
    }

    //Task 8
    public Mono<ApiDto> webClientRequest(String query) {
        return webClient.get()
                .uri(API_URL + query)
                .retrieve()
                .bodyToMono(ApiDto.class);
    }
}
