package com.myfinances.statistics.controllers;

import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import com.myfinances.statistics.models.request.EarnedByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByCategoryStatisticRequest;
import com.myfinances.statistics.models.request.SpentByMonthByCategoryStatisticRequest;
import com.myfinances.statistics.models.request.SpentByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorStatisticRequest;
import com.myfinances.statistics.models.response.ListOfKeyValuePairs;
import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.services.StatisticsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/statistics")
public class StatisticsController {
    private StatisticsService service;

    @PostMapping("change-by-date")
    public ResponseEntity<List<ListOfKeyValuePairs>> getChangeByDate(@Valid @RequestBody ChangeByDateStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getChangeByDate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-vendor")
    public ResponseEntity<List<KeyValuePair>> getSpentByVendor(@Valid @RequestBody SpentByVendorStatisticRequest request) {
        List<KeyValuePair> response = this.service.getSpentByVendor(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-vendor-by-payment-option")
    public ResponseEntity<List<ListOfKeyValuePairs>> getSpentByVendorByPaymentOption(@Valid @RequestBody SpentByVendorByPaymentOptionStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getSpentByVendorByPaymentOption(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-payment-option")
    public ResponseEntity<List<KeyValuePair>> getSpentByPaymentOption(@Valid @RequestBody SpentByPaymentOptionStatisticRequest request) {
        List<KeyValuePair> response = this.service.getSpentByPaymentOption(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("earned-by-month")
    public ResponseEntity<List<ListOfKeyValuePairs>> getEarnedByMonth(@Valid @RequestBody EarnedByMonthStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getEarnedByMonth(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-month")
    public ResponseEntity<List<ListOfKeyValuePairs>> getSpentByMonth(@Valid @RequestBody SpentByMonthStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getSpentByMonth(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-month-by-category")
    public ResponseEntity<List<ListOfKeyValuePairs>> getSpentByMonthByCategory(@Valid @RequestBody SpentByMonthByCategoryStatisticRequest request) {
        List<ListOfKeyValuePairs> response = this.service.getSpentByMonthByCategory(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("spent-by-category")
    public ResponseEntity<List<KeyValuePair>> getSpentByCategory(@Valid @RequestBody SpentByCategoryStatisticRequest request) {
        List<KeyValuePair> response = this.service.getSpentByCategory(request);
        return ResponseEntity.ok(response);
    }
}
