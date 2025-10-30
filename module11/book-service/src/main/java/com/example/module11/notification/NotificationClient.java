package com.example.module11.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
//@RequiredArgsConstructor
//public class NotificationClient {
//    private final RestTemplate restTemplate;
//    private final DiscoveryClient discoveryClient;
//
//    public void sendNotification() {
//        restTemplate.postForEntity("http://notification:8080/notify", null, String.class);
//    }
//
//    //Task 6
//    public void sendNotificationWithDiscoveryClient() {
//        ServiceInstance instance = discoveryClient.getInstances("NOTIFICATION").get(0);
//        restTemplate.postForEntity(instance.getUri().toString() + "/notify", null, String.class);
//    }
//}


@Service
@RequiredArgsConstructor
public class NotificationClient {
    private final RestTemplate restTemplate;

    //Task 7
    public void sendNotification() {
        restTemplate.postForEntity("http://NOTIFICATION/notify", null, String.class);
    }

}

