package com.myfinances.apigateway.models.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KeyValuePair {
    private String name;
    private float value;
}
