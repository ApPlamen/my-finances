package com.myfinances.apigateway.models.internal.statistics;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EarnedByMonthStatisticInternalRequest {
    private int userId;
}
