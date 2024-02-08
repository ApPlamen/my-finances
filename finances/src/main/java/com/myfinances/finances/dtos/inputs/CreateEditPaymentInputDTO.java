package com.myfinances.finances.dtos.inputs;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CreateEditPaymentInputDTO extends UpdateDTO<Payment, Optional<Integer>> {
    private String description;
    private float amount;

    @Override
    public Payment toEntity(Payment payment) {
        payment.setDescription(this.getDescription());
        payment.setAmount(this.getAmount());

        return payment;
    }
}
