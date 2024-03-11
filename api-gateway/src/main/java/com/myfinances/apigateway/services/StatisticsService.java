package com.myfinances.apigateway.services;

import com.myfinances.apigateway.helpers.SecurityContextHelper;
import com.myfinances.apigateway.models.internal.statistics.ChangeByDateStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.EarnedByMonthStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.SpentByMonthByCategoryStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.SpentByMonthStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.SpentByPaymentOptionStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.SpentByVendorByPaymentOptionStatisticInternalRequest;
import com.myfinances.apigateway.models.internal.statistics.SpentByVendorStatisticInternalRequest;
import com.myfinances.apigateway.models.request.statistics.ChangeByDateStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByPaymentOptionStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByVendorByPaymentOptionStatisticRequest;
import com.myfinances.apigateway.models.request.statistics.SpentByVendorStatisticRequest;
import com.myfinances.apigateway.models.response.statistics.ListOfKeyValuePairs;
import com.myfinances.apigateway.models.response.statistics.KeyValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService extends BaseRestService {
    public StatisticsService(@Value("${statistics.service.baseUrl}") String baseUrl) {
        super(baseUrl, "statistics");
    }

    public List<ListOfKeyValuePairs> getChangeByDate(ChangeByDateStatisticRequest request) {
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

    public List<ListOfKeyValuePairs> getSpentByVendorByPaymentOption(SpentByVendorByPaymentOptionStatisticRequest request) {
        int userId = SecurityContextHelper.getUserId();

        SpentByVendorByPaymentOptionStatisticInternalRequest body = SpentByVendorByPaymentOptionStatisticInternalRequest.builder()
                .userId(userId)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return restClient.post()
                .uri("/spent-by-vendor-by-payment-option")
                .body(body)
                .retrieve()
                .body(List.class);
    }

    public List<KeyValuePair> getSpentByPaymentOption(SpentByPaymentOptionStatisticRequest request) {
        int userId = SecurityContextHelper.getUserId();

        SpentByPaymentOptionStatisticInternalRequest body = SpentByPaymentOptionStatisticInternalRequest.builder()
                .userId(userId)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return restClient.post()
                .uri("/spent-by-payment-option")
                .body(body)
                .retrieve()
                .body(List.class);
    }

    public List<ListOfKeyValuePairs> getEarnedByMonth() {
        int userId = SecurityContextHelper.getUserId();

        EarnedByMonthStatisticInternalRequest body = EarnedByMonthStatisticInternalRequest.builder()
                .userId(userId)
                .build();

        return restClient.post()
                .uri("/earned-by-month")
                .body(body)
                .retrieve()
                .body(List.class);
    }

    public List<ListOfKeyValuePairs> getSpentByMonth() {
        int userId = SecurityContextHelper.getUserId();

        SpentByMonthStatisticInternalRequest body = SpentByMonthStatisticInternalRequest.builder()
                .userId(userId)
                .build();

        return restClient.post()
                .uri("/spent-by-month")
                .body(body)
                .retrieve()
                .body(List.class);
    }

    public List<ListOfKeyValuePairs> getSpentByMonthByCategory() {
        int userId = SecurityContextHelper.getUserId();

        SpentByMonthByCategoryStatisticInternalRequest body = SpentByMonthByCategoryStatisticInternalRequest.builder()
                .userId(userId)
                .build();

        return restClient.post()
                .uri("/spent-by-month-by-category")
                .body(body)
                .retrieve()
                .body(List.class);
    }
}
