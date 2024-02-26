package com.myfinances.statistics.controllers;

import com.myfinances.statistics.models.ChangeByDateStatisticData;
import com.myfinances.statistics.services.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/statistics")
public class StatisticsController {
    private StatisticsService service;

    @GetMapping("change-by-date")
    public ResponseEntity<List<ChangeByDateStatisticData>> getChangeByDate() {
        List<ChangeByDateStatisticData> response = this.service.getChangeByDate();
        return ResponseEntity.ok(response);
    }
}
