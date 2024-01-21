package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.model.request.LoginReq;
import com.myfinances.apigateway.model.response.LoginRes;
import com.myfinances.apigateway.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth Controller")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginRes> login(@RequestBody LoginReq loginReq) {
        LoginRes loginRes = authService.login(loginReq);
        return ResponseEntity.ok(loginRes);
    }
}
