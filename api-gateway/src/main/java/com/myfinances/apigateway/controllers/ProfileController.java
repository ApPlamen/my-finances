package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.request.ChangePasswordRequest;
import com.myfinances.apigateway.models.request.ProfileRequest;
import com.myfinances.apigateway.models.response.ProfileResponse;
import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.services.ProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/profile")
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class ProfileController {
    private final ProfileService service;

    @GetMapping("")
    public ResponseEntity<ProfileResponse> getProfile() {
        ProfileResponse response = this.service.getProfile();
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    public void saveProfile(@RequestBody ProfileRequest profile) {
        this.service.saveProfile(profile);
    }

    @PutMapping("change-password")
    public void changePassword(@RequestBody ChangePasswordRequest passwordModel) {
        this.service.changePassword(passwordModel);
    }
}
