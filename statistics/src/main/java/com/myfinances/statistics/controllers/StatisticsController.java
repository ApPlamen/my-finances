package com.myfinances.statistics.controllers;

import com.myfinances.statistics.models.response.ChangeByDateStatisticData;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
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
    public ResponseEntity<List<ChangeByDateStatisticData>> getChangeByDate(@Valid @RequestBody ChangeByDateStatisticRequest request) {
        List<ChangeByDateStatisticData> response = this.service.getChangeByDate(request);
        return ResponseEntity.ok(response);
    }
}
