package com.myfinances.apigateway.models.request.finances;

import com.myfinances.apigateway.models.request.UpdateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentUpdateRequest extends UpdateRequest<Integer> {
    private String description;
    private float amount;
}
