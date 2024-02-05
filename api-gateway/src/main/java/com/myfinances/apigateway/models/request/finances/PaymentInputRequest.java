package com.myfinances.apigateway.models.request.finances;

import com.myfinances.apigateway.models.request.InputRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInputRequest extends InputRequest {
    private String description;
    private float amount;
}
