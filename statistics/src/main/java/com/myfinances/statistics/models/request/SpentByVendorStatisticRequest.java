package com.myfinances.statistics.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SpentByVendorStatisticRequest {
    private Date startDate;
    private Date endDate;
    @NotNull
    private int userId;
}
