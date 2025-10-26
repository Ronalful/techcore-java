package org.example.task8;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: бин инициализирован");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy: бин уничтожается");
    }
}
