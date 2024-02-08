package com.myfinances.finances.controllers;

import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.views.PaymentBoardItemViewDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.services.PaymentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("board")
    public ResponseEntity<List<PaymentBoardItemViewDTO>> getBoard() {
        List<PaymentBoardItemViewDTO> response = this.service.getBoard();
        return ResponseEntity.ok(response);
    }
}
