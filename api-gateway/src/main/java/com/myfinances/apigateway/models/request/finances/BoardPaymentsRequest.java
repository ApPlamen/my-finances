package com.myfinances.apigateway.models.request.finances;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardPaymentsRequest {
    private Date startDate;
    private Date endDate;
}
