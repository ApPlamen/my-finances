package com.myfinances.finances.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentOptionViewDTO {
    private int value;
    private String displayValue;
}
