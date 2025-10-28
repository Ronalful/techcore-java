package com.example.module8.auth;

import com.example.module8.user.Role;
import com.example.module8.user.User;
import com.example.module8.user.UserMapper;
import com.example.module8.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        return userRepository.save(
                User.builder()
                        .username(request.username())
                        .password(passwordEncoder.encode(request.password()))
                        .role(Role.USER)
                        .build()
        );
    }
}
