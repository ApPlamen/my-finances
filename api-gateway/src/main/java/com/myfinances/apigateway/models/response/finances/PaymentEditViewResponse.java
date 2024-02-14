package com.myfinances.apigateway.models.response.finances;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentEditViewResponse {
    private int id;
    private String description;
    private String vendor;
    private float amount;
    private Date dateTime;
    private boolean income;
    private int paymentOption;
}
