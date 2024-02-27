package com.myfinances.finances.controllers;

import com.myfinances.finances.dtos.inputs.CreateEditPaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentActiveInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.request.BoardPaymentsRequest;
import com.myfinances.finances.dtos.views.PaymentBoardItemViewDTO;
import com.myfinances.finances.dtos.views.PaymentEditViewDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.services.PaymentsService;
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
public class PaymentsController extends CRUDController<Payment, Integer, PaymentInputDTO, PaymentUpdateDTO, PaymentViewDTO> {
    private final PaymentsService service;

    public PaymentsController(PaymentsService service) {
        super(service);
        this.service = service;
    }

    @PostMapping("board")
    public ResponseEntity<List<PaymentBoardItemViewDTO>> getBoard(@Valid @RequestBody BoardPaymentsRequest request) {
        List<PaymentBoardItemViewDTO> response = this.service.getBoard(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("get-edit/{paymentId}")
    public ResponseEntity<PaymentEditViewDTO> getById(@PathVariable int paymentId) {
        PaymentEditViewDTO response = this.service.getEditPayment(paymentId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create-edit-payment")
    public void createEditPayment(@Valid @RequestBody CreateEditPaymentInputDTO request) {
        this.service.createEditPayment(request);
    }

    @PostMapping("set-active")
    public void setActive(@Valid @RequestBody PaymentActiveInputDTO request) {
        this.service.setActive(request);
    }
}
