package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.request.LoginRequest;
import com.myfinances.apigateway.models.request.RegisterRequest;
import com.myfinances.apigateway.models.response.LoginResponse;
import com.myfinances.apigateway.services.AuthService;
import com.myfinances.apigateway.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
@Tag(name = "Auth Controller")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(value = "/register")
    public void register(@Valid @RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
    }
}
