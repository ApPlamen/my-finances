package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.statistics.KeyValuePair;
import com.myfinances.apigateway.models.statistics.TestStatisticData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    public List<TestStatisticData> getTest() {
        List<KeyValuePair> series = new ArrayList<>();
        series.add(new KeyValuePair("01.02.24", 200));
        series.add(new KeyValuePair("02.02.24", 100));
        series.add(new KeyValuePair("03.02.24", 20));
        series.add(new KeyValuePair("04.02.24", -50));
        series.add(new KeyValuePair("05.02.24", -40));
        series.add(new KeyValuePair("06.02.24", 30));
        series.add(new KeyValuePair("07.02.24", -3));
        series.add(new KeyValuePair("08.02.24", 2));
        series.add(new KeyValuePair("09.02.24", 0));

        TestStatisticData amountData = TestStatisticData.builder()
                .name("Amount")
                .series(series)
                .build();

        List<TestStatisticData> data = new ArrayList<>();
        data.add(amountData);

        return data;
    }
}
