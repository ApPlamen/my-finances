package com.myfinances.apigateway.models.response.finances;

import com.myfinances.apigateway.models.response.ViewResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentViewResponse extends ViewResponse {
    private int id;
    private String description;
    private float amount;
}
