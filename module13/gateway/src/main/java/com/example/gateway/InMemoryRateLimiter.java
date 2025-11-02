package com.example.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryRateLimiter implements RateLimiter<Object> {
    private final int replenishRate = 5;
    private final int burstCapacity = 5;
    private final Map<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        TokenBucket tokenBucket = buckets.computeIfAbsent(id, k -> new TokenBucket(burstCapacity, replenishRate));
        boolean allowed = tokenBucket.tryConsume();
        return Mono.just(new Response(allowed, allowed ? Map.of() : Map.of("X-RateLimit-Retry-After-Seconds", "60")));
    }

    @Override
    public Map<String, Object> getConfig() {
        return Map.of();
    }

    @Override
    public Class<Object> getConfigClass() {
        return Object.class;
    }

    @Override
    public Object newConfig() {
        return new Object();
    }

    private static class TokenBucket {
        private final int capacity;
        private final int refillRate;
        private int tokens;
        private Instant lastRefill;

        public TokenBucket(int capacity, int refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity;
            this.lastRefill = Instant.now();
        }

        synchronized boolean tryConsume() {
            refill();
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }

        private void refill() {
            Instant now = Instant.now();
            long seconds = java.time.Duration.between(lastRefill, now).getSeconds();
            if (seconds > 0) {
                tokens = Math.min(capacity, tokens + (int)(seconds * refillRate / 60));
                lastRefill = now;
            }
        }
    }
}
