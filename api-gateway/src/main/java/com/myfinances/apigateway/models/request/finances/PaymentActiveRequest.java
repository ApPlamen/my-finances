package com.myfinances.apigateway.models.request.finances;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentActiveRequest {
    @NotBlank
    private int paymentId;
    @NotBlank
    private boolean active;
}
