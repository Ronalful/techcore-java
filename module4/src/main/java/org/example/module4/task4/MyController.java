package org.example.module4.task4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final MyService service;
}
