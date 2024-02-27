package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
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
}
