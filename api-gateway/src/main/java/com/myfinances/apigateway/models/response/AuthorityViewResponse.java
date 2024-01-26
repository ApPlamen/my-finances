package com.myfinances.apigateway.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorityViewResponse extends ViewResponse {
    private int id;
    private String name;
}
