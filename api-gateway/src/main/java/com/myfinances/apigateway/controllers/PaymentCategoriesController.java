package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.models.response.finances.PaymentCategoryResponse;
import com.myfinances.apigateway.services.PaymentCategoriesService;
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
@RequestMapping("api/payment-categories")
@Tag(name = "Payment Categories Controller")
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class PaymentCategoriesController {
    private PaymentCategoriesService service;

    @GetMapping("options")
    public ResponseEntity<List<PaymentCategoryResponse>> getPaymentCategoriesOptions() {
        List<PaymentCategoryResponse> options = service.getPaymentCategoriesOptions();
        return ResponseEntity.ok(options);
    }
}
