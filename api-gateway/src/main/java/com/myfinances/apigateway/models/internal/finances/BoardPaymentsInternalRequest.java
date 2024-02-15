package com.myfinances.apigateway.models.internal.finances;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class BoardPaymentsInternalRequest {
    private String description;
    private String vendor;
    private Date startDate;
    private Date endDate;
    private int userId;
}
