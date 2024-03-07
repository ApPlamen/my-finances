package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.response.finances.PaymentCategoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentCategoriesService extends BaseRestService {
    public PaymentCategoriesService(@Value("${finances.service.baseUrl}") String baseUrl) {
        super(baseUrl, "payment-categories");
    }

    public List<PaymentCategoryResponse> getPaymentCategoriesOptions() {
        return restClient.get()
                .uri("/options")
                .retrieve()
                .body(List.class);
    }
}
