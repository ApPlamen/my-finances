package com.myfinances.statistics.models.sql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpentByVendorByPaymentOptionSQLResponse {
    public float amount;
    public String vendor;
    public String paymentOption;
}
