package com.myfinances.finances.dtos.views;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentEditViewDTO {
    private int id;
    private String description;
    private String vendor;
    private float amount;
    private Date dateTime;
    private boolean income;
    private int paymentOption;
    private int paymentCategory;

    public static PaymentEditViewDTO create(Payment payment) {
        PaymentEditViewDTO dto = new PaymentEditViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setVendor(payment.getVendor());
        dto.setPaymentOption(payment.getPaymentOption().getId());
        dto.setPaymentCategory(payment.getPaymentCategory().getId());
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
