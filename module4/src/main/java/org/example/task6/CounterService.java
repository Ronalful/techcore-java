package org.example.task6;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounterService {
    private final ObjectFactory<Counter> counterFactory;

    public void demonstrate() {
        Counter c1 = counterFactory.getObject();
        Counter c2 = counterFactory.getObject();

        System.out.println("Первый бин: " + c1 + ", count = " + c1.getCount());
        c1.increment();
        System.out.println("После инкремента: count = " + c1.getCount());

        System.out.println("Второй бин: " + c2 + ", count = " + c2.getCount());
    }
}
