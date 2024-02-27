package com.myfinances.finances.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentActiveInputDTO {
    @NotBlank
    private int paymentId;
    @NotBlank
    private boolean active;
}
