package com.example.module11.notification;

import com.example.module11.book.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NotificationClient {
    private final RestTemplate restTemplate;

    public void sendNotification() {
        restTemplate.postForEntity("http://notification:8080/notify", null, String.class);
    }
}
