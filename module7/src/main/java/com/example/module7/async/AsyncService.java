package com.example.module7.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    //Task 5
    @Async
    public void doSomething() {
        System.out.println("Начало работы async");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Конец работы async");
    }
}
