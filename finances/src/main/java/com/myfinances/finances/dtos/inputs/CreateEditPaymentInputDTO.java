package com.myfinances.finances.dtos.inputs;

import com.myfinances.finances.entities.Payment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class CreateEditPaymentInputDTO extends UpdateDTO<Payment, Optional<Integer>> {
    @NotBlank
    private String description;
    @NotBlank
    private String vendor;
    @NotNull
    private float amount;
    @NotNull
    private Date dateTime;
    @NotNull
    private boolean income;
    @NotNull
    private int userId;
    @NotNull
    private int paymentOption;
    private int paymentCategory;

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
