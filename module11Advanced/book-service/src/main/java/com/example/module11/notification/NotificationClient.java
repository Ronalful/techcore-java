package com.example.module11.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NotificationClient {
    private final RestTemplate restTemplate;

    public void sendNotification() {
        restTemplate.postForEntity("http://notification-service:8081/notify", null, String.class);
    }

}

