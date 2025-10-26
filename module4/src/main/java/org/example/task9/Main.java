package org.example.task9;

import lombok.RequiredArgsConstructor;
import org.example.task6.CounterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {
    private final MessageService messageService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Сообщение: " + messageService.getMessage());
    }
}
