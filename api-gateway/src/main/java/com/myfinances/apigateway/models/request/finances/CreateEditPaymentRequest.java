package com.myfinances.apigateway.models.request.finances;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CreateEditPaymentRequest {
    private Optional<Integer> id;
    private String description;
    private float amount;
    private boolean income;
    private int paymentOption;
}