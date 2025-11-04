package com.example.module11.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NotificationClient {
    private final RestTemplate restTemplate;

    public void sendNotification() {
        //Task 4
        restTemplate.postForEntity("http://NOTIFICATION-SERVICE/notify", null, String.class);
    }

}

