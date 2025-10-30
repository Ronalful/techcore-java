package com.example.notification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @PostMapping("/notify")
    public ResponseEntity<Void> doNotification() {
        System.out.println("Notification triggered");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
