package com.myfinances.finances.dtos.views;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentEditViewDTO {
    private int id;
    private String description;
    private float amount;

    public static PaymentEditViewDTO create(Payment payment) {
        PaymentEditViewDTO dto = new PaymentEditViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setAmount(payment.getAmount());

        return dto;
    }
}
