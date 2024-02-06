package com.myfinances.apigateway.services;

import com.myfinances.apigateway.auth.JwtUtil;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.request.users.LoginRequest;
import com.myfinances.apigateway.models.response.users.LoginResponse;
import com.myfinances.apigateway.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        String userName = authentication.getName();

        List<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        User user = User.builder()
                .id(securityUser.getId())
                .userName(securityUser.getUsername())
                .active(securityUser.isEnabled())
                .build();

        String token = jwtUtil.createToken(user, authorities);
        return new LoginResponse(userName, token, authorities);
    }
}
