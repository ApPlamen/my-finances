package com.myfinances.apigateway.services;

import com.myfinances.apigateway.auth.JwtUtil;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.request.LoginRequest;
import com.myfinances.apigateway.models.response.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        String userName = authentication.getName();

        List<String> authorities = authentication.getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toList());

        User user = User.builder()
                .userName(userName)
                .build();

        String token = jwtUtil.createToken(user);
        LoginResponse loginResponse = new LoginResponse(userName, token, authorities);
        return loginResponse;
    }
}
