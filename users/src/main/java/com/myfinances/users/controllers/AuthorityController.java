package com.myfinances.users.controllers;

import com.myfinances.users.dtos.views.RolesOptionViewDTO;
import com.myfinances.users.services.AuthorityService;
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
    public ResponseEntity<List<RolesOptionViewDTO>> getRolesOptions() {
        List<RolesOptionViewDTO> options = service.getRolesOptions();
        return ResponseEntity.ok(options);
    }
}
