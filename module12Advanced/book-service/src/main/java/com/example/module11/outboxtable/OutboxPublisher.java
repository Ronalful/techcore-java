package com.example.module11.outboxtable;

import com.example.module11.kafka.BookCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OutboxPublisher {
    private final OutboxRepository outboxRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedDelay = 5000)
    public void publish() {
        List<Outbox> events = outboxRepository.findByProcessedFalse();

        for (Outbox event : events) {
            try {
                Class<?> eventClass = getEventClass(event.getAggregateType());
                Object payloadObject = objectMapper.readValue(event.getPayload(), eventClass);

                kafkaTemplate.send(
                        event.getAggregateType().toString().toLowerCase() + "_events",
                        event.getAggregateId().toString(),
                        payloadObject
                );
                event.setProcessed(true);
                outboxRepository.save(event);
            } catch (Exception e) {
                log.error("Failed to send event: {}", e.getMessage());
            }
        }
    }

    private Class<?> getEventClass(AggregateType aggregateType) {
        switch (aggregateType) {
            case BOOK:
                return BookCreatedEvent.class;
            default:
                throw new IllegalArgumentException("Unknown aggregateType: " + aggregateType);
        }
    }
}
