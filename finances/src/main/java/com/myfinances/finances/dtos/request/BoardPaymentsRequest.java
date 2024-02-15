package com.myfinances.finances.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardPaymentsRequest {
    private Date startDate;
    private Date endDate;
    private int userId;
}
