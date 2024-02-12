package com.myfinances.finances.dtos.views;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentBoardItemViewDTO {
    private int id;
    private String description;
    private float amount;
    private boolean income;
    private String paymentOption;
    private boolean active;

    public static PaymentBoardItemViewDTO create(Payment payment) {
        PaymentBoardItemViewDTO dto = new PaymentBoardItemViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setPaymentOption(payment.getPaymentOption().getDescription());
        dto.setActive(payment.isActive());

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
