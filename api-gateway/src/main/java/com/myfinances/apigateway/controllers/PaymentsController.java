package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.services.PaymentsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
@Tag(name = "Payments Controller")
@AllArgsConstructor
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class PaymentsController {
    private final PaymentsService paymentsService;
}
