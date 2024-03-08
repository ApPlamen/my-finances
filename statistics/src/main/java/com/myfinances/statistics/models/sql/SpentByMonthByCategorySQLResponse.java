package com.myfinances.statistics.models.sql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpentByMonthByCategorySQLResponse {
    private float amount;
    private String paymentCategory;
    private String month;
    private String year;
}
