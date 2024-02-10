package com.myfinances.apigateway.models.response.finances;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentEditViewResponse {
    private int id;
    private String description;
    private float amount;
    private boolean income;
}
