package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.models.request.statistics.ChangeByDateStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByPaymentOptionStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByVendorByPaymentOptionStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByVendorStatisticRequest;
import com.myfinances.apigateway.models.response.statistics.ListOfKeyValuePairs;
import com.myfinances.apigateway.models.response.statistics.KeyValuePair;
import com.myfinances.apigateway.services.StatisticsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("change-by-date")
    public ResponseEntity<List<ListOfKeyValuePairs>> getChangeByDate(@RequestBody ChangeByDateStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getChangeByDate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-vendor")
    public ResponseEntity<List<KeyValuePair>> getSpentByVendor(@RequestBody SpentByVendorStatisticRequest request) {
        List<KeyValuePair> response = this.service.getSpentByVendor(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-vendor-by-payment-option")
    public ResponseEntity<List<ListOfKeyValuePairs>> getSpentByVendorByPaymentOption(@RequestBody SpentByVendorByPaymentOptionStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getSpentByVendorByPaymentOption(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-payment-option")
    public ResponseEntity<List<KeyValuePair>> getSpentByPaymentOption(@RequestBody SpentByPaymentOptionStatisticRequest request) {
        List<KeyValuePair> response = this.service.getSpentByPaymentOption(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("earned-by-month")
    public ResponseEntity<List<ListOfKeyValuePairs>> getEarnedByMonth() {
        List<ListOfKeyValuePairs> response = this.service.getEarnedByMonth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("spent-by-month")
    public ResponseEntity<List<ListOfKeyValuePairs>> getSpentByMonth() {
        List<ListOfKeyValuePairs> response = this.service.getSpentByMonth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("spent-by-month-by-category")
    public ResponseEntity<List<ListOfKeyValuePairs>> getSpentByMonthByCategory() {
        List<ListOfKeyValuePairs> response = this.service.getSpentByMonthByCategory();
        return ResponseEntity.ok(response);
    }
}
