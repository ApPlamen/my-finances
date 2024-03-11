package com.myfinances.statistics.services;

import com.myfinances.statistics.infrastructure.PaymentsRepo;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import com.myfinances.statistics.models.request.EarnedByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByCategoryStatisticRequest;
import com.myfinances.statistics.models.request.SpentByMonthByCategoryStatisticRequest;
import com.myfinances.statistics.models.request.SpentByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorStatisticRequest;
import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.models.response.ListOfKeyValuePairs;
import com.myfinances.statistics.models.sql.AmountByMonthAndYearSQLResponse;
import com.myfinances.statistics.models.sql.SpentByMonthByCategorySQLResponse;
import com.myfinances.statistics.models.sql.SpentByVendorByPaymentOptionSQLResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
                .collect(Collectors.groupingBy(SpentByVendorByPaymentOptionSQLResponse::getVendor))
                .forEach((key, value) -> {
                    List<KeyValuePair> series = new ArrayList<>();
                    value.forEach(v -> series.add(new KeyValuePair(v.getPaymentOption(), v.getAmount())));
                    data.add(new ListOfKeyValuePairs(key, series));
                });

        return data;
    }

    public List<KeyValuePair> getSpentByPaymentOption(SpentByPaymentOptionStatisticRequest request) {
        return repo.getSpentByPaymentOption(request);
    }

    public List<ListOfKeyValuePairs> getEarnedByMonth(EarnedByMonthStatisticRequest request) {
        List<AmountByMonthAndYearSQLResponse> response = repo.getEarnedByMonth(request);

        List<ListOfKeyValuePairs> data = new ArrayList<>();

        response.stream()
                .collect(Collectors.groupingBy(AmountByMonthAndYearSQLResponse::getYear))
                .forEach((key, value) -> {
                    List<KeyValuePair> series = new ArrayList<>();
                    value.forEach(v -> series.add(new KeyValuePair(v.getMonth(), v.getAmount())));
                    data.add(new ListOfKeyValuePairs(key, series));
                });

        return data;
    }

    public List<ListOfKeyValuePairs> getSpentByMonth(SpentByMonthStatisticRequest request) {
        List<AmountByMonthAndYearSQLResponse> response = repo.getSpentByMonth(request);

        List<ListOfKeyValuePairs> data = new ArrayList<>();

        response.stream()
                .collect(Collectors.groupingBy(AmountByMonthAndYearSQLResponse::getYear))
                .forEach((key, value) -> {
                    List<KeyValuePair> series = new ArrayList<>();
                    value.forEach(v -> series.add(new KeyValuePair(v.getMonth(), v.getAmount())));
                    data.add(new ListOfKeyValuePairs(key, series));
                });

        return data;
    }

    public List<ListOfKeyValuePairs> getSpentByMonthByCategory(SpentByMonthByCategoryStatisticRequest request) {
        List<SpentByMonthByCategorySQLResponse> response = repo.getSpentByMonthByCategory(request);

        List<ListOfKeyValuePairs> data = new ArrayList<>();

        response.stream()
                .collect(Collectors.groupingBy(g -> g.getMonth() + "." + g.getYear(), LinkedHashMap::new, Collectors.toList()))
                .forEach((key, value) -> {
                    List<KeyValuePair> series = new ArrayList<>();
                    value.forEach(v -> series.add(new KeyValuePair(v.getPaymentCategory(), v.getAmount())));
                    data.add(new ListOfKeyValuePairs(key, series));
                });

        return data;
    }

    public List<KeyValuePair> getSpentByCategory(SpentByCategoryStatisticRequest request) {
        return repo.getSpentByCategory(request);
    }
}
