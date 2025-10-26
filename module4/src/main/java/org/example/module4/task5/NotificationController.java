package org.example.module4.task5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(
            @Qualifier("emailNotificationService")
            NotificationService notificationService
    ) {
        this.notificationService = notificationService;
    }
}
