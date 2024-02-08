package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.Payment;
import com.myfinances.apigateway.models.request.finances.PaymentInputRequest;
import com.myfinances.apigateway.models.request.finances.PaymentUpdateRequest;
import com.myfinances.apigateway.models.response.finances.PaymentViewResponse;
import com.myfinances.apigateway.models.response.finances.PaymentBoardItemResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputRequest, PaymentUpdateRequest, PaymentViewResponse> {
    public PaymentsService(@Value("${finances.service.baseUrl}") String baseUrl) {
        super(baseUrl, "payments");
    }

    public List<PaymentBoardItemResponse> getBoard() {
        return restClient.get()
                .uri("/board")
                .retrieve()
                .body(List.class);
    }
}
