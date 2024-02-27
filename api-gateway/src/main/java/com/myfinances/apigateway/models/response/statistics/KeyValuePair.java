package com.myfinances.apigateway.models.response.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KeyValuePair {
    private String name;
    private float value;
}
