package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.statistics.ChangeByDateStatisticData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService extends BaseRestService {
    public StatisticsService(@Value("${statistics.service.baseUrl}") String baseUrl) {
        super(baseUrl, "statistics");
    }

    public List<ChangeByDateStatisticData> getChangeByDate() {
        return restClient.get()
                .uri("/change-by-date")
                .retrieve()
                .body(List.class);
    }
}
