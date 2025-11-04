package com.example.gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter implements WebFilter {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (isTokenMissing(exchange)) {
            return chain.filter(exchange);
        }

        String token = getJwtToken(exchange);
        String username;
        Collection<SimpleGrantedAuthority> authorities;

        try {
            username = jwtTokenProvider.extractUsername(token);
            authorities = jwtTokenProvider.extractAuthorities(token);
        } catch (Exception e) {
            return chain.filter(exchange);
        }

        if (username == null) {
            return chain.filter(exchange);
        }


        if (jwtTokenProvider.isTokenValid(token)) {
            var userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password("")
                    .authorities(authorities)
                    .build();
            var auth = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            return chain.filter(exchange)
                    .contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));
        }

        return chain.filter(exchange);
    }

    private boolean isTokenMissing(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return authHeader == null ||!authHeader.startsWith("Bearer ");
    }

    private String getJwtToken(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return authHeader.substring(7);
    }


}
