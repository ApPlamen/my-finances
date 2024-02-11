package com.myfinances.finances.infrastructure;

import com.myfinances.finances.entities.PaymentOption;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentOptionsRepo extends Repo<PaymentOption, Integer> {
}
