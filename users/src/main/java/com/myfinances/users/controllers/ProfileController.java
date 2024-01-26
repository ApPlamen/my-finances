package com.myfinances.users.controllers;

import com.myfinances.users.dtos.inputs.ProfileUpdateDTO;
import com.myfinances.users.dtos.views.ProfileViewDTO;
import com.myfinances.users.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/profile")
public class ProfileController {
    private final ProfileService service;

    @GetMapping("/{userId}")
    public ResponseEntity<ProfileViewDTO> getProfile(@PathVariable int userId) {
        ProfileViewDTO response = this.service.getProfile(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    public void saveProfile(@RequestBody ProfileUpdateDTO profile) {
        this.service.saveProfile(profile);
    }
}
