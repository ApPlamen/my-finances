package com.myfinances.statistics.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChangeByDateStatisticRequest {
    private Date startDate;
    private Date endDate;
    @NotBlank
    private int userId;
}
