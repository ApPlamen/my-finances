package com.myfinances.finances.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentActiveInputDTO {
    private int paymentId;
    private boolean active;
}
