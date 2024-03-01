package com.myfinances.statistics.models.sql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountByMonthAndYearSQLResponse {
    private float amount;
    private String month;
    private String year;
}
