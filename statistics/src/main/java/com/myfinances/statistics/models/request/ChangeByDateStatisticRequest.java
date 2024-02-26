package com.myfinances.statistics.models.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChangeByDateStatisticRequest {
    private Date startDate;
    private Date endDate;
    private int userId;
}
