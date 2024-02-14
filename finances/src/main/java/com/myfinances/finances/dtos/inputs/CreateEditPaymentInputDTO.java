package com.myfinances.finances.dtos.inputs;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class CreateEditPaymentInputDTO extends UpdateDTO<Payment, Optional<Integer>> {
    private String description;
    private String vendor;
    private float amount;
    private Date dateTime;
    private boolean income;
    private int userId;
    private int paymentOption;

    @Override
    public Payment toEntity(Payment payment) {
        payment.setDescription(this.getDescription());
        payment.setVendor(this.getVendor());
        payment.setUserId(this.getUserId());

        float amount = this.getAmount();
        if (!this.income) {
            amount = (-1) * amount;
        }
        payment.setAmount(amount);

        Timestamp ts = new Timestamp(this.getDateTime().getTime());
        payment.setDateTime(ts);

        return payment;
    }
}
