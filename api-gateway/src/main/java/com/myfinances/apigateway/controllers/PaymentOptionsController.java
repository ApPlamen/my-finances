package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.models.response.users.RolesOptionResponse;
import com.myfinances.apigateway.services.PaymentOptionsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/payment-options")
@Tag(name = "Payment Options Controller")
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class PaymentOptionsController {
    private PaymentOptionsService service;

    @GetMapping("options")
    public ResponseEntity<List<RolesOptionResponse>> getPaymentOptions() {
        List<RolesOptionResponse> options = service.getPaymentOptions();
        return ResponseEntity.ok(options);
    }
}
