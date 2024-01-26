package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.response.ProfileResponse;
import com.myfinances.apigateway.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/profile")
public class ProfileController {
    private final ProfileService service;

    @GetMapping("")
    public ResponseEntity<ProfileResponse> getProfile() {
        ProfileResponse response = this.service.getProfile();
        return ResponseEntity.ok(response);
    }
}
