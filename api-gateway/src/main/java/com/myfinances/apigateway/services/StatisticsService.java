package com.myfinances.apigateway.services;

import com.myfinances.apigateway.helpers.SecurityContextHelper;
import com.myfinances.apigateway.models.internal.statistics.ChangeByDateStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.SpentByVendorStatisticInternalRequest;
import com.myfinances.apigateway.models.request.statistics.ChangeByDateStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByVendorStatisticRequest;
import com.myfinances.apigateway.models.response.statistics.ChangeByDateStatisticData;
import com.myfinances.apigateway.models.response.statistics.KeyValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService extends BaseRestService {
    public StatisticsService(@Value("${statistics.service.baseUrl}") String baseUrl) {
        super(baseUrl, "statistics");
    }

    public List<ChangeByDateStatisticData> getChangeByDate(ChangeByDateStatisticRequest request) {
        int userId = SecurityContextHelper.getUserId();

        ChangeByDateStatisticInternalRequest body = ChangeByDateStatisticInternalRequest.builder()
                .userId(userId)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return restClient.post()
                .uri("/change-by-date")
                .body(body)
                .retrieve()
                .body(List.class);
    }

    public List<KeyValuePair> getSpentByVendor(SpentByVendorStatisticRequest request) {
        int userId = SecurityContextHelper.getUserId();

        SpentByVendorStatisticInternalRequest body = SpentByVendorStatisticInternalRequest.builder()
                .userId(userId)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return restClient.post()
                .uri("/spent-by-vendor")
                .body(body)
                .retrieve()
                .body(List.class);
    }
}
