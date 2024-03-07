package com.myfinances.finances.services;

import com.myfinances.finances.dtos.views.PaymentCategoryViewDTO;
import com.myfinances.finances.entities.PaymentCategory;
import com.myfinances.finances.infrastructure.PaymentCategoriesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentCategoriesService {
    private final PaymentCategoriesRepo repo;

    public PaymentCategory findById(int id) {
        return this.repo.findById(id).orElseThrow();
    }

    public List<PaymentCategoryViewDTO> getPaymentCategoriesOptions() {
        return this.repo.findAll()
                .stream()
                .map(option -> PaymentCategoryViewDTO.builder()
                        .value(option.getId())
                        .displayValue(option.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
