package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.services.FinancesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/finances")
@Tag(name = "Finances Controller")
@AllArgsConstructor
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class FinancesController {
    private final FinancesService financesService;
}
