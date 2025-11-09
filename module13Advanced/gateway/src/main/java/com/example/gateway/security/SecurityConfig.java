package com.example.gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/api/auth/**").permitAll()
                        .pathMatchers("/actuator/**").permitAll()
                        .anyExchange().authenticated()
                )
                .addFilterAt(jwtTokenFilter, SecurityWebFiltersOrder.AUTHENTICATION);

        return http.build();
    }


}
