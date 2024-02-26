package com.myfinances.apigateway.models.internal.statistics;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ChangeByDateStatisticInternalRequest {
    private Date startDate;
    private Date endDate;
    private int userId;
}
