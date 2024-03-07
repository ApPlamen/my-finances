package com.myfinances.apigateway.models.request.finances;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private float amount;
    @NotNull
    private Date dateTime;
    @NotNull
    private boolean income;
    @NotNull
    private int userId;
    @NotNull
    private int paymentOption;
    private int paymentCategory;
}
