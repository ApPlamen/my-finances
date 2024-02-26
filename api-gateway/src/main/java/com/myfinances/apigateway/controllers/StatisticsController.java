package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.models.statistics.ChangeByDateStatisticData;
import com.myfinances.apigateway.services.StatisticsService;
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
@RequestMapping("api/statistics")
@Tag(name = "Statistics Controller")
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class StatisticsController {
    private StatisticsService service;

    @GetMapping("change-by-date")
    public ResponseEntity<List<ChangeByDateStatisticData>> getChangeByDate() {
        List<ChangeByDateStatisticData> response = this.service.getChangeByDate();
        return ResponseEntity.ok(response);
    }
}
