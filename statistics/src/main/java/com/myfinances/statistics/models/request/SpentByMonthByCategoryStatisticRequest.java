package com.myfinances.statistics.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpentByMonthByCategoryStatisticRequest {
    @NotNull
    private int userId;
}
