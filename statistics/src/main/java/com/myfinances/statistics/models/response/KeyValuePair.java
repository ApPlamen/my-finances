package com.myfinances.statistics.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KeyValuePair {
    private String name;
    private float value;
}
