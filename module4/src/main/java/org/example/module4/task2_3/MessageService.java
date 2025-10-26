package org.example.module4.task2_3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Value("${app.greeting}")
    private String message;

    public String getMessage() {
        return message;
    }
}
