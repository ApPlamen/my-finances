package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.Payment;
import com.myfinances.apigateway.models.request.finances.PaymentInputRequest;
import com.myfinances.apigateway.models.request.finances.PaymentUpdateRequest;
import com.myfinances.apigateway.models.response.finances.PaymentViewResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputRequest, PaymentUpdateRequest, PaymentViewResponse> {
    PaymentsService(@Value("${FINANCES_SERVICE_URL}") String baseUrl) {
        super(baseUrl, "payments");
    }
}
