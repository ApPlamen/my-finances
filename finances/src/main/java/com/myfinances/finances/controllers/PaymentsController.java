package com.myfinances.finances.controllers;

import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.services.PaymentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
public class PaymentsController extends CRUDController<Payment, Integer, PaymentInputDTO, PaymentUpdateDTO, PaymentViewDTO> {
    public PaymentsController(PaymentsService service) {
        super(service);
    }
}
