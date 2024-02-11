package com.myfinances.finances.infrastructure;

import com.myfinances.finances.entities.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends Repo<Payment, Integer> {
    public List<Payment> findAllByOrderByIdAsc();
}
