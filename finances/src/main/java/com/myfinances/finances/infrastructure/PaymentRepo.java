package com.myfinances.finances.infrastructure;

import com.myfinances.finances.entities.Payment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends Repo<Payment, Integer>, JpaSpecificationExecutor<Payment> {
}
