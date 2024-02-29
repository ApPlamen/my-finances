package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
import com.myfinances.statistics.models.request.SpentByVendorStatisticRequest;
import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.models.response.ListOfKeyValuePairs;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
    private final PaymentsRepo repo;

    public List<ListOfKeyValuePairs> getChangeByDate(ChangeByDateStatisticRequest request) {
        List<KeyValuePair> series = repo.getChangeByDate(request);

        ListOfKeyValuePairs amountData = ListOfKeyValuePairs.builder()
                .name("Amount")
                .series(series)
                .build();

        List<ListOfKeyValuePairs> data = new ArrayList<>();
        data.add(amountData);

        return data;
    }

    public List<KeyValuePair> getSpentByVendor(SpentByVendorStatisticRequest request) {
        return repo.getSpentByVendor(request);
    }
}
