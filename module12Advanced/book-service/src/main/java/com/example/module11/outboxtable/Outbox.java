package com.example.module11.outboxtable;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Outbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AggregateType aggregateType;

    private Long aggregateId;

    @Enumerated(EnumType.STRING)
    private EventType type;

    @Column(name = "payload", nullable = false, columnDefinition = "TEXT")
    private String payload;

    private LocalDateTime createdAt;

    private Boolean processed;
}
