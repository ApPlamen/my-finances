package com.myfinances.apigateway.models.response.statistics;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ListOfKeyValuePairs {
    private String name;
    private List<KeyValuePair> series;
}
