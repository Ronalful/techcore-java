package com.example.module11.outboxtable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {

    List<Outbox> findByProcessedFalse();
}
