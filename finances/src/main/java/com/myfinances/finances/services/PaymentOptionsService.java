package com.myfinances.finances.services;

import com.myfinances.finances.entities.PaymentOption;
import com.myfinances.finances.infrastructure.PaymentOptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentOptionsService {
    private final PaymentOptionsRepo repo;

    public PaymentOption findById(int id) {
        return this.repo.findById(id).orElseThrow();
    }
}
