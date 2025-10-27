package com.example.module6advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Module6AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(Module6AdvancedApplication.class, args);
    }

}
