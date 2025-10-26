package org.example.task10;

import lombok.RequiredArgsConstructor;
import org.example.task9.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {
    private final FeatureService featureService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        featureService.doSomething();
    }
}
