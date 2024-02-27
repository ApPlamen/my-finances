package com.myfinances.apigateway.models.request.finances;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentActiveRequest {
    @NotNull
    private int paymentId;
    @NotNull
    private boolean active;
}
