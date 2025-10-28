package com.example.module8.auth;

import com.example.module8.jwt.JwtTokenProvider;
import com.example.module8.user.Role;
import com.example.module8.user.User;
import com.example.module8.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public User register(RegisterRequest request) {
        return userRepository.save(
                User.builder()
                        .username(request.username())
                        .password(passwordEncoder.encode(request.password()))
                        .role(Role.USER)
                        .build()
        );
    }

    //Task 5
//    public void login(RegisterRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.username(),
//                        request.password()
//                )
//        );
//    }

    //Task 7
    public AuthResponse login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        return new AuthResponse(jwtTokenProvider.generateToken(request.username()));
    }
}
