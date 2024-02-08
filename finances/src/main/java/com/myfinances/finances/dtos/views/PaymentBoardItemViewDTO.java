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

    public static PaymentBoardItemViewDTO create(Payment payment) {
        PaymentBoardItemViewDTO dto = new PaymentBoardItemViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setAmount(payment.getAmount());

        return dto;
    }
}
