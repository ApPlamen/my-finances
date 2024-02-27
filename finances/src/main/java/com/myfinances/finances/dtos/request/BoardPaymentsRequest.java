package com.myfinances.finances.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardPaymentsRequest {
    private String description;
    private String vendor;
    private Date startDate;
    private Date endDate;
    @NotNull
    private int userId;
}
