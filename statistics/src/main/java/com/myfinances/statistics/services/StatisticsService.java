package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
import com.myfinances.statistics.models.KeyValuePair;
import com.myfinances.statistics.models.TestStatisticData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
    private final PaymentsRepo repo;

    public List<TestStatisticData> getTest() {
        List<KeyValuePair> series = repo.getTest();

        TestStatisticData amountData = TestStatisticData.builder()
                .name("Amount")
                .series(series)
                .build();

        List<TestStatisticData> data = new ArrayList<>();
        data.add(amountData);

        return data;
    }
}
