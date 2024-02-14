package com.myfinances.finances.dtos.views;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentBoardItemViewDTO {
    private int id;
    private String description;
    private String vendor;
    private float amount;
    private Date dateTime;
    private boolean income;
    private String paymentOption;
    private boolean active;

    public static PaymentBoardItemViewDTO create(Payment payment) {
        PaymentBoardItemViewDTO dto = new PaymentBoardItemViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setVendor(payment.getVendor());
        dto.setPaymentOption(payment.getPaymentOption().getDescription());
        dto.setActive(payment.isActive());
        dto.setDateTime(payment.getDateTime());

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
