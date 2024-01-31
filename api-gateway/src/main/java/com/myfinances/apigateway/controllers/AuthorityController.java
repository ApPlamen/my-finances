package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.response.RolesOptionResponse;
import com.myfinances.apigateway.services.AuthorityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/authorities")
public class AuthorityController {
    private AuthorityService service;

    @GetMapping("options-roles")
    public ResponseEntity<List<RolesOptionResponse>> getRolesOptions() {
        List<RolesOptionResponse> options = service.getRolesOptions();
        return ResponseEntity.ok(options);
    }
}
