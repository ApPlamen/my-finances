package com.myfinances.apigateway.models.request.finances;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentActiveRequest {
    private int paymentId;
    private boolean active;
}
