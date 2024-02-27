package com.myfinances.finances.dtos.inputs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentActiveInputDTO {
    @NotNull
    private int paymentId;
    @NotNull
    private boolean active;
}
