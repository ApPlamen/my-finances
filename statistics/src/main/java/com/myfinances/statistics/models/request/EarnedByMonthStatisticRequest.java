package com.myfinances.statistics.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EarnedByMonthStatisticRequest {
    @NotNull
    private int userId;
}
