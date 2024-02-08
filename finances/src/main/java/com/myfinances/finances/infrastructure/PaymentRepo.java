package com.myfinances.finances.infrastructure;

import com.myfinances.finances.entities.Payment;

import java.util.List;

public interface PaymentRepo extends Repo<Payment, Integer> {
    public List<Payment> findAllByOrderByIdAsc();
}
