package com.myfinances.statistics.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TestStatisticData {
    private String name;
    private List<KeyValuePair> series;
}
