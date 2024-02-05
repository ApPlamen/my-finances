package com.myfinances.finances.services;

import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.infrastructure.PaymentRepo;

public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputDTO, PaymentUpdateDTO, PaymentViewDTO> {
    public PaymentsService(PaymentRepo repo) {
        super(repo);
    }

    @Override
    protected PaymentViewDTO toView(Payment payment) {
        return PaymentViewDTO.builder()
                .id(payment.getId())
                .description(payment.getDescription())
                .amount(payment.getAmount())
                .build();
    }
}
