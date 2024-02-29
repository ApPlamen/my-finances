package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
import com.myfinances.statistics.models.request.SpentByVendorByPaymentOptionStatisticRequest;
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

    public List<ListOfKeyValuePairs> getSpentByVendorByPaymentOption(SpentByVendorByPaymentOptionStatisticRequest request) {
        List<ListOfKeyValuePairs> data = new ArrayList<>();

        List<KeyValuePair> series1 = new ArrayList<>();
        series1.add(new KeyValuePair("2010", 7300000));
        series1.add(new KeyValuePair("2011", 8940000));
        data.add(new ListOfKeyValuePairs("Germany", series1));

        List<KeyValuePair> series2 = new ArrayList<>();
        series2.add(new KeyValuePair("2010", 7870000));
        series2.add(new KeyValuePair("2011", 8270000));
        data.add(new ListOfKeyValuePairs("USA", series2));

        List<KeyValuePair> series3 = new ArrayList<>();
        series3.add(new KeyValuePair("2010", 5000002));
        series3.add(new KeyValuePair("2011", 5800000));
        data.add(new ListOfKeyValuePairs("France", series3));

        return data;
    }
}
