package com.myfinances.apigateway.models.request.statistics;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChangeByDateStatisticRequest {
    private Date startDate;
    private Date endDate;
}
