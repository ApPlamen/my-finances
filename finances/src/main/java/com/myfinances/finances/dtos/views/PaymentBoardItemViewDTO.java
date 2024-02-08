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

    public static PaymentBoardItemViewDTO create(Payment user) {
        PaymentBoardItemViewDTO dto = new PaymentBoardItemViewDTO();

        dto.setId(user.getId());
        dto.setDescription(user.getDescription());
        dto.setAmount(user.getAmount());

        return dto;
    }
}
