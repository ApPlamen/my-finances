package com.myfinances.apigateway.services;

import com.myfinances.apigateway.auth.JwtUtil;
import com.myfinances.apigateway.model.entities.User;
import com.myfinances.apigateway.model.request.LoginReq;
import com.myfinances.apigateway.model.response.LoginRes;
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

    public LoginRes login(LoginReq loginReq){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUserName(), loginReq.getPassword()));
        String userName = authentication.getName();
        User user = new User(userName, "");
        String token = jwtUtil.createToken(user);
        LoginRes loginRes = new LoginRes(userName, token);
        return  loginRes;
    }
}
