package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.response.finances.PaymentOptionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentOptionsService extends BaseRestService {
    public PaymentOptionsService(@Value("${finances.service.baseUrl}") String baseUrl) {
        super(baseUrl, "payment-options");
    }

    public List<PaymentOptionResponse> getPaymentOptionsOptions() {
        return restClient.get()
                .uri("/options")
                .retrieve()
                .body(List.class);
    }
}
