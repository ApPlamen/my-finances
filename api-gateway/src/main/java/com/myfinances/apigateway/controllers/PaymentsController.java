package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.entities.Payment;
import com.myfinances.apigateway.models.request.finances.BoardPaymentsRequest;
import com.myfinances.apigateway.models.request.finances.CreateEditPaymentRequest;
import com.myfinances.apigateway.models.request.finances.PaymentActiveRequest;
import com.myfinances.apigateway.models.request.finances.PaymentInputRequest;
import com.myfinances.apigateway.models.request.finances.PaymentUpdateRequest;
import com.myfinances.apigateway.models.response.finances.PaymentViewResponse;
import com.myfinances.apigateway.models.response.finances.PaymentBoardItemResponse;
import com.myfinances.apigateway.models.response.finances.PaymentEditViewResponse;
import com.myfinances.apigateway.services.PaymentsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("board")
    public ResponseEntity<List<PaymentBoardItemResponse>> getBoard(@RequestBody BoardPaymentsRequest request) {
        List<PaymentBoardItemResponse> response = this.service.getBoard(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("get-edit/{paymentId}")
    public ResponseEntity<PaymentEditViewResponse> getById(@PathVariable int paymentId) {
        PaymentEditViewResponse response = this.service.getEditPayment(paymentId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create-edit-payment")
    public void createEditPayment(@Valid @RequestBody CreateEditPaymentRequest request) {
        this.service.createEditPayment(request);
    }

    @PostMapping("set-active")
    public void setActive(@Valid @RequestBody PaymentActiveRequest request) {
        this.service.setActive(request);
    }
}
