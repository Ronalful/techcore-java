package com.example.module7;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//Task 4
@Service
public class ScheduleService {
    @Scheduled(cron = "0 * * * * ?")
    public void runScheduleTask() {
        System.out.println("Running schedule task...");
    }
}
