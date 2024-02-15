package com.myfinances.apigateway.models.request.finances;

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
}
