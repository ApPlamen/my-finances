package com.myfinances.apigateway.models.statistics;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ChangeByDateStatisticData {
    private String name;
    private List<KeyValuePair> series;
}
