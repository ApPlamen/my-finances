package com.myfinances.statistics.models.sql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpentByVendorByPaymentOptionSQLResponse {
    private float amount;
    private String vendor;
    private String paymentOption;
}
