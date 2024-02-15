package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.Payment;
import com.myfinances.apigateway.helpers.SecurityContextHelper;
import com.myfinances.apigateway.models.internal.finances.BoardPaymentsInternalRequest;
import com.myfinances.apigateway.models.request.finances.BoardPaymentsRequest;
import com.myfinances.apigateway.models.request.finances.CreateEditPaymentRequest;
import com.myfinances.apigateway.models.request.finances.PaymentActiveRequest;
import com.myfinances.apigateway.models.request.finances.PaymentInputRequest;
import com.myfinances.apigateway.models.request.finances.PaymentUpdateRequest;
import com.myfinances.apigateway.models.response.finances.PaymentBoardItemResponse;
import com.myfinances.apigateway.models.response.finances.PaymentEditViewResponse;
import com.myfinances.apigateway.models.response.finances.PaymentViewResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputRequest, PaymentUpdateRequest, PaymentViewResponse> {
    public PaymentsService(@Value("${finances.service.baseUrl}") String baseUrl) {
        super(baseUrl, "payments");
    }

    public List<PaymentBoardItemResponse> getBoard(BoardPaymentsRequest request) {
        int userId = SecurityContextHelper.getUserId();

        BoardPaymentsInternalRequest body = BoardPaymentsInternalRequest.builder()
                .userId(userId)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return restClient.post()
                .uri("/board")
                .body(body)
                .retrieve()
                .body(List.class);
    }

    public PaymentEditViewResponse getEditPayment(int paymentId) {
        return restClient.get()
                .uri("/get-edit/" + paymentId)
                .retrieve()
                .body(PaymentEditViewResponse.class);
    }

    public void createEditPayment(CreateEditPaymentRequest request) {
        int userId = SecurityContextHelper.getUserId();
        request.setUserId(userId);

        restClient.post()
                .uri("/create-edit-payment")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public void setActive(PaymentActiveRequest request) {
        restClient.post()
                .uri("/set-active")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}
