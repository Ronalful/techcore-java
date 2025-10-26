package org.example.module4.task4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {
    private final MyRepository repository;
}
