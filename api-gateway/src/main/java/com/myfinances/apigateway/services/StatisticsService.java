package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.statistics.TestStatisticData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService extends BaseRestService {
    public StatisticsService(@Value("${statistics.service.baseUrl}") String baseUrl) {
        super(baseUrl, "statistics");
    }

    public List<TestStatisticData> getTest() {
        return restClient.get()
                .uri("/test")
                .retrieve()
                .body(List.class);
    }
}
