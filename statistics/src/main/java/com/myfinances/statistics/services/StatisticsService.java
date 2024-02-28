package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
import com.myfinances.statistics.models.request.SpentByVendorStatisticRequest;
import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.models.response.ChangeByDateStatisticData;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
    private final PaymentsRepo repo;

    public List<ChangeByDateStatisticData> getChangeByDate(ChangeByDateStatisticRequest request) {
        List<KeyValuePair> series = repo.getChangeByDate(request);

        ChangeByDateStatisticData amountData = ChangeByDateStatisticData.builder()
                .name("Amount")
                .series(series)
                .build();

        List<ChangeByDateStatisticData> data = new ArrayList<>();
        data.add(amountData);

        return data;
    }

    public List<KeyValuePair> getSpentByVendor(SpentByVendorStatisticRequest request) {
        List<KeyValuePair> result = new ArrayList<>();
        result.add(new KeyValuePair("Germany", 8940000));
        result.add(new KeyValuePair("USA", 5000000));
        result.add(new KeyValuePair("France", 7200000));
        result.add(new KeyValuePair("UK", 6200000));
        result.add(new KeyValuePair("Bulgaria", 3100000));

        return result;
    }
}
