package com.myfinances.apigateway.models.response.finances;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentOptionResponse {
    private int value;
    private String displayValue;
}
