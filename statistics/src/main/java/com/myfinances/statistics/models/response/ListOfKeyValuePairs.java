package com.myfinances.statistics.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ListOfKeyValuePairs {
    private String name;
    private List<KeyValuePair> series;
}
