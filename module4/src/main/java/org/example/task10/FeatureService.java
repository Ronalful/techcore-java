package org.example.task10;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        name = "feature.toggle.enable",
        havingValue = "true"
)
public class FeatureService {
    public FeatureService() {
        System.out.println("FeatureService создан");
    }

    public void doSomething() {
        System.out.println("Функциональность включена!");
    }
}
