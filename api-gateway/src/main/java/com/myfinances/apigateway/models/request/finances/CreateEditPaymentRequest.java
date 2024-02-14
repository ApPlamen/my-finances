package com.myfinances.apigateway.models.request.finances;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class CreateEditPaymentRequest {
    private Optional<Integer> id;
    private String description;
    private String vendor;
    private float amount;
    private Date dateTime;
    private boolean income;
    private int userId;
    private int paymentOption;
}
