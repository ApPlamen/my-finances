package com.myfinances.finances.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PaymentViewDTO implements ViewDTO {
    private int id;
    private String description;
    private float amount;
}
