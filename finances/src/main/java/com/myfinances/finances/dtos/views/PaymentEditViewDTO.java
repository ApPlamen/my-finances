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
    private boolean income;
    private int paymentOption;

    public static PaymentEditViewDTO create(Payment payment) {
        PaymentEditViewDTO dto = new PaymentEditViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setPaymentOption(payment.getPaymentOption().getId());

        float amount = payment.getAmount();

        if (amount >= 0) {
            dto.setIncome(true);
            dto.setAmount(amount);
        } else {
            dto.setIncome(false);
            amount = (-1) * amount;
            dto.setAmount(amount);
        }

        return dto;
    }
}
