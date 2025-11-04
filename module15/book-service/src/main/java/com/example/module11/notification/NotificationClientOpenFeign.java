package com.example.module11.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("NOTIFICATION-SERVICE")
public interface NotificationClientOpenFeign {
    @PostMapping("/notify")
    void doNotification();
}
