package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import com.myfinances.statistics.models.request.EarnedByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorStatisticRequest;
import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.models.response.ListOfKeyValuePairs;
import com.myfinances.statistics.models.sql.SpentByVendorByPaymentOptionSQLResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<SpentByVendorByPaymentOptionSQLResponse> response = repo.getSpentByVendorByPaymentOption(request);

        List<ListOfKeyValuePairs> data = new ArrayList<>();

        response.stream()
                .collect(Collectors.groupingBy(r -> r.vendor))
                .forEach((key, value) -> {
                    List<KeyValuePair> series = new ArrayList<>();
                    value.forEach(v -> series.add(new KeyValuePair(v.paymentOption, v.amount)));
                    data.add(new ListOfKeyValuePairs(key, series));
                });

        return data;
    }

    public List<KeyValuePair> getSpentByPaymentOption(SpentByPaymentOptionStatisticRequest request) {
        return repo.getSpentByPaymentOption(request);
    }

    public List<ListOfKeyValuePairs> getEarnedByMonth(EarnedByMonthStatisticRequest request) {
        List<KeyValuePair> series = new ArrayList<>();
        series.add(new KeyValuePair("01", 20));
        series.add(new KeyValuePair("02", 30));
        series.add(new KeyValuePair("03", 10));

        ListOfKeyValuePairs data = new ListOfKeyValuePairs("2023", series);

        List<ListOfKeyValuePairs> result = new ArrayList<>();
        result.add(data);
        return result;
    }

    public List<ListOfKeyValuePairs> getSpentByMonth(SpentByMonthStatisticRequest request) {
        List<KeyValuePair> series = new ArrayList<>();
        series.add(new KeyValuePair("01", 10));
        series.add(new KeyValuePair("02", 20));
        series.add(new KeyValuePair("03", 30));

        ListOfKeyValuePairs data = new ListOfKeyValuePairs("2023", series);

        List<ListOfKeyValuePairs> result = new ArrayList<>();
        result.add(data);
        return result;
    }
}
