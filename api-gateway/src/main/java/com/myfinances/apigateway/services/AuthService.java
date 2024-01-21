package com.myfinances.apigateway.services;

import com.myfinances.apigateway.auth.JwtUtil;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.model.request.LoginRequest;
import com.myfinances.apigateway.model.response.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

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
        User user = new User(userName, "");
        String token = jwtUtil.createToken(user);
        LoginResponse loginResponse = new LoginResponse(userName, token);
        return loginResponse;
    }
}
