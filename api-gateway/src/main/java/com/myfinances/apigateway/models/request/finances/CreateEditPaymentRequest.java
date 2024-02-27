package com.myfinances.apigateway.models.request.finances;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
public class CreateEditPaymentRequest {
    private Optional<Integer> id;
    @NotBlank
    private String description;
    @NotBlank
    private String vendor;
    @NotBlank
    private float amount;
    @NotBlank
    private Date dateTime;
    @NotBlank
    private boolean income;
    @NotBlank
    private int userId;
    @NotBlank
    private int paymentOption;
}
