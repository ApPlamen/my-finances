package com.myfinances.finances.dtos.inputs;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentUpdateDTO extends UpdateDTO<Payment,Integer> {
    private String description;
    private float amount;

    @Override
    public Payment toEntity(Payment payment) {
        payment.setId(this.getId());
        payment.setDescription(this.getDescription());
        payment.setAmount(this.getAmount());

        return payment;
    }
}
