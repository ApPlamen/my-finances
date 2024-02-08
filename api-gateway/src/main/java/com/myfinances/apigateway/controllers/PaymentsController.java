package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.entities.Payment;
import com.myfinances.apigateway.models.request.finances.PaymentInputRequest;
import com.myfinances.apigateway.models.request.finances.PaymentUpdateRequest;
import com.myfinances.apigateway.models.response.finances.PaymentViewResponse;
import com.myfinances.apigateway.models.response.finances.PaymentBoardItemResponse;
import com.myfinances.apigateway.services.PaymentsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@Tag(name = "Payments Controller")
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class PaymentsController extends CRUDController<Payment, Integer, PaymentInputRequest, PaymentUpdateRequest, PaymentViewResponse> {
    private final PaymentsService service;

    public PaymentsController(PaymentsService paymentsService) {
        super(paymentsService);
        this.service = paymentsService;
    }

    @GetMapping("board")
    public ResponseEntity<List<PaymentBoardItemResponse>> getBoard() {
        List<PaymentBoardItemResponse> response = this.service.getBoard();
        return ResponseEntity.ok(response);
    }
}
