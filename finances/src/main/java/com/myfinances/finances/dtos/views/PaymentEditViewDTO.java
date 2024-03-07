package com.myfinances.finances.dtos.views;

import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.entities.PaymentCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;

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
    private Optional<Integer> paymentCategory;

    public static PaymentEditViewDTO create(Payment payment) {
        PaymentEditViewDTO dto = new PaymentEditViewDTO();

        dto.setId(payment.getId());
        dto.setDescription(payment.getDescription());
        dto.setVendor(payment.getVendor());
        dto.setPaymentOption(payment.getPaymentOption().getId());
        dto.setDateTime(payment.getDateTime());

        PaymentCategory pc = payment.getPaymentCategory();
        if (pc != null) {
            dto.setPaymentCategory(Optional.of(pc.getId()));
        }

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
