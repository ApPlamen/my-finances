package com.myfinances.finances.services;

import com.myfinances.finances.dtos.views.PaymentOptionViewDTO;
import com.myfinances.finances.entities.PaymentOption;
import com.myfinances.finances.infrastructure.PaymentOptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentOptionsService {
    private final PaymentOptionsRepo repo;

    public PaymentOption findById(int id) {
        return this.repo.findById(id).orElseThrow();
    }

    public List<PaymentOptionViewDTO> getPaymentOptions() {
        return this.repo.findAll()
                .stream()
                .map(option -> PaymentOptionViewDTO.builder()
                        .value(option.getId())
                        .displayValue(option.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
