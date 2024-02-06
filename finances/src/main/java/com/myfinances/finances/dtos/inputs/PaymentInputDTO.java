package com.myfinances.finances.dtos.inputs;

import com.myfinances.finances.entities.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInputDTO extends InputDTO<Payment> {
    private int id;
    private String description;
    private float amount;

    @Override
    public Payment toEntity() {
        Payment paymentEntity = new Payment();
        paymentEntity.setId(this.getId());
        paymentEntity.setDescription(this.getDescription());
        paymentEntity.setAmount(this.getAmount());

        return paymentEntity;
    }
}
